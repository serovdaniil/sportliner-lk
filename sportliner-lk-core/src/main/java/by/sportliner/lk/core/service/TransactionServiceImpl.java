package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.*;
import by.sportliner.lk.core.repository.TransactionRepository;
import by.sportliner.lk.core.service.email.EmailService;
import by.sportliner.lk.core.service.email.UpdatedInvoicesData;
import by.sportliner.lk.core.service.integration.epos.EposHgroshService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private ApplicationSettingsService applicationSettingsService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ChildService childService;

    @Autowired
    private EposHgroshService eposHgroshService;

    @Autowired
    private EmailService emailService;

    @Override
    public Transaction addNewTransactionForChild(Child child) {
        if (child.getPaymentType().equals(PaymentType.PER_LESSON)) {
            return null;
        }

        Transaction transaction = toTransaction(child);

        eposHgroshService.updateInvoiceFor(child.getFullInvoiceNumber(), transaction);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction addTransactionForNewChild(Child child) {
        BigDecimal totalAmount;
        Tariff childTariff = child.getTariff();
        int countLessons = 0;

        if (childTariff.equals(Tariff.UNLIM)) {
            BigDecimal currentDay = BigDecimal.valueOf(LocalDate.now().getDayOfMonth());
            BigDecimal allDay = BigDecimal.valueOf(YearMonth.now().lengthOfMonth());

            BigDecimal percentage = currentDay.divide(allDay, 2, RoundingMode.HALF_UP);
            PaymentSettings.PriceItem subscriptionPrice = loadPaymentSettings().getCurrentPrice()
                .get(PaymentSettings.Type.UNLIM);

            totalAmount = child.isBenefits() ? subscriptionPrice.benefitsPrice() : subscriptionPrice.normalPrice()
                .multiply(BigDecimal.ONE.subtract(percentage));
        } else {
            int countWeeks = countWeeksBetweenCurrentDateAndEndDate();
            countLessons = countWeeks * childTariff.getLessonsPerWeek();
            PaymentSettings.PriceItem subscriptionPrice = loadPaymentSettings().getCurrentPrice()
                .get(PaymentSettings.Type.getByCountLessons(countLessons));

            totalAmount = child.isBenefits() ? subscriptionPrice.benefitsPrice() : subscriptionPrice.normalPrice();
        }

        Transaction transaction = new Transaction();

        transaction.setChild(child);
        transaction.setDate(LocalDate.now());
        transaction.setStatus(Transaction.Status.UNPAID);
        transaction.setInvoiceAmount(totalAmount);
        transaction.setNumberOfLessons(countLessons);

        eposHgroshService.updateInvoiceFor(child.getFullInvoiceNumber(), transaction);

        transactionRepository.save(transaction);

        return transaction;
    }

    @Scheduled(cron = "0 12 20 5 * *")
    public void monthlyBilling() {
        LOGGER.debug("Automatic updating of accounts has been started");

        List<Child> children = childService.findAll();
        List<Transaction> transactions = new ArrayList<>();

        for (Child child : children) {
            if ((child.getTuitionBalance() > child.getTariff().getLessonsPerWeek() * 4)
                || child.getPaymentType().equals(PaymentType.PER_LESSON)) {
                continue;
            }

            Transaction transaction = addNewTransactionForChild(child);
            transactions.add(transaction);
        }

        UpdatedInvoicesData updatedInvoicesData = new UpdatedInvoicesData()
            .data(transactions);

        emailService.notifyAboutUpdatedInvoices(updatedInvoicesData);

        LOGGER.debug("Finished automatic updating of accounts");
    }

    @Scheduled(cron = "0 45 23 * * *")
    public void dailyCheckInvoices() {
        LocalDate currentDate = LocalDate.now();
        List<Transaction> transactions = transactionRepository.findByStatus(Transaction.Status.UNPAID);
        List<by.sportliner.lk.integration.epos.hgrosh.internal.api.Transaction> transactionRecords =
            eposHgroshService.findTransactionInvoices(currentDate);

        Predicate<Child> containsInTransactionRecords = child -> transactionRecords.stream()
            .anyMatch(it -> it.getInvoice().getNumber().equals(child.getInvoiceNumber()));

        List<Transaction> paidTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            Child child = transaction.getChild();

            if (containsInTransactionRecords.test(child)) {
                transaction.setStatus(Transaction.Status.PAID);
                transactionRepository.save(transaction);

                child.incrementTuitionBalance(transaction.getNumberOfLessons());
                childService.save(child);

                paidTransactions.add(transaction);
            }
        }

        emailService.notifyAboutPaidInvoices(paidTransactions);

        List<Child> children = childService.findWithPerLessonPaymentTypeAndAttendanceForDay(currentDate);

        for (Child child : children) {
            if (containsInTransactionRecords.test(child)) {
                child.incrementTuitionBalance();
                childService.save(child);
            }

            emailService.notifyAboutUnpaidPerLessonInvoice(child);
        }

    }

    @Scheduled(cron = "0 0 9 16 * *")
    public void notifyAboutUnpaidInvoices() {
        List<Transaction> transactions = transactionRepository.findByStatus(Transaction.Status.UNPAID);

        if (transactions.isEmpty()) {
            return;
        }

        emailService.notifyAboutUnpaidInvoices(transactions);
    }

    private PaymentSettings loadPaymentSettings() {
        return applicationSettingsService.getPaymentSettings();
    }

    private int countWeeksBetweenCurrentDateAndEndDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = YearMonth.now().atEndOfMonth();

        if (currentDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            currentDate = currentDate.plusDays(3);
        } else if (currentDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            currentDate = currentDate.plusDays(2);
        } else if (currentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            currentDate = currentDate.plusDays(1);
        }

        int countDays = endDate.getDayOfMonth() - currentDate.getDayOfMonth() + 1;

        if (countDays > 28) {
            return 5;
        } else if (countDays > 21) {
            return 4;
        } else if (countDays > 14) {
            return 3;
        } else if (countDays > 7) {
            return 2;
        } else {
            return 1;
        }
    }

    private BigDecimal countInvoiceAmount(Child child) {
        return switch (child.getPaymentType()) {
            case PREPAYMENT -> countInvoiceAmountForPrepayment(child);
            case POST_PAYMENT -> countInvoiceAmountForPostPaymentType(child);
            case PER_LESSON ->
                throw new TransactionException("Do not bill monthly for the \"Per lesson\" payment type.");
        };
    }

    private BigDecimal countInvoiceAmountForPostPaymentType(Child child) {
        Tariff tariff = child.getTariff();
        PaymentSettings paymentSettings = loadPaymentSettings();
        Map<PaymentSettings.Type, PaymentSettings.PriceItem> subscriptionPrice = paymentSettings.isUsePrevPrice()
            ? paymentSettings.getPrevPrice()
            : paymentSettings.getCurrentPrice();

        if (tariff.equals(Tariff.UNLIM)) {
            PaymentSettings.PriceItem priceItem = subscriptionPrice.get(PaymentSettings.Type.UNLIM);

            return child.isBenefits() ? priceItem.benefitsPrice() : priceItem.normalPrice();
        }

        int countLessons = child.getTuitionBalance() * -1; // need to convert to positive number

        PaymentSettings.PriceItem priceItem = subscriptionPrice.get(PaymentSettings.Type.getByCountLessons(countLessons));

        return child.isBenefits() ? priceItem.benefitsPrice() : priceItem.normalPrice();

    }

    private BigDecimal countInvoiceAmountForPrepayment(Child child) {
        Tariff tariff = child.getTariff();
        PaymentSettings paymentSettings = loadPaymentSettings();

        if (tariff.equals(Tariff.UNLIM)) {
            PaymentSettings.PriceItem priceItem = paymentSettings.getCurrentPrice().get(PaymentSettings.Type.UNLIM);

            return child.isBenefits() ? priceItem.benefitsPrice() : priceItem.normalPrice();
        }

        if (child.getTuitionBalance() < 0 && paymentSettings.isUsePrevPrice()) {
            BigDecimal amount = BigDecimal.ZERO;

            int countLessonsByPrevPrice = child.getTuitionBalance() * -1; // need to convert to positive number

            PaymentSettings.PriceItem prevPriceItem = paymentSettings.getPrevPrice()
                .get(PaymentSettings.Type.getByCountLessons(countLessonsByPrevPrice));

            amount = amount.add(child.isBenefits() ? prevPriceItem.benefitsPrice() : prevPriceItem.normalPrice());

            int countLessonsByNewPrice = tariff.getLessonsPerWeek() * 4;
            PaymentSettings.PriceItem currentPriceItem = paymentSettings.getCurrentPrice()
                .get(PaymentSettings.Type.getByCountLessons(countLessonsByNewPrice));

            amount = amount.add(child.isBenefits() ? currentPriceItem.benefitsPrice() : currentPriceItem.normalPrice());

            return amount;
        }

        int numberLessonsForPaid = (tariff.getLessonsPerWeek() * 4) - child.getTuitionBalance();

        PaymentSettings.PriceItem priceItem = paymentSettings.getCurrentPrice()
            .get(PaymentSettings.Type.getByCountLessons(numberLessonsForPaid));

        return child.isBenefits() ? priceItem.benefitsPrice() : priceItem.normalPrice();
    }

    private Transaction toTransaction(Child child) {
        Transaction transaction = new Transaction();

        transaction.setChild(child);
        transaction.setDate(LocalDate.now());
        transaction.setStatus(Transaction.Status.UNPAID);
        transaction.setInvoiceAmount(countInvoiceAmount(child));
        transaction.setNumberOfLessons(child.getAmountClassesForPay());

        return transaction;
    }

}
