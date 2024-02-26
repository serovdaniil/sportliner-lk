package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.PaymentType;
import by.sportliner.lk.core.model.Tariff;
import by.sportliner.lk.core.model.Transaction;
import by.sportliner.lk.core.repository.TransactionRepository;
import by.sportliner.lk.core.service.email.EmailService;
import by.sportliner.lk.core.service.email.UpdatedInvoicesData;
import by.sportliner.lk.core.service.integration.epos.EposHgroshService;
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
import java.util.function.Predicate;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private static final double BENEFIT_DISCOUNT = 0.1;

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

            totalAmount = BigDecimal.valueOf(Tariff.UNLIM.getPrice())
                .multiply(BigDecimal.ONE.subtract(percentage));
        } else {
            int countWeeks = countWeeksBetweenCurrentDateAndEndDate();
            countLessons = countWeeks * childTariff.getLessonsPerWeek();

            totalAmount = BigDecimal.valueOf(countLessons * childTariff.getPrice());
        }

        if (child.isBenefits()) {
            totalAmount = totalAmount.divide(BigDecimal.valueOf(1 - BENEFIT_DISCOUNT), 2, RoundingMode.HALF_UP);
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

    @Scheduled(cron = "0 0 1 1 * *")
    public void monthlyBilling() {
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
        Tariff tariff = child.getTariff();
        BigDecimal amount;

        if (tariff.equals(Tariff.UNLIM)) {
            amount = BigDecimal.valueOf(tariff.getPrice());
        } else {
            amount = BigDecimal.valueOf(child.getAmountClassesForPay() * tariff.getPrice());
        }

        return child.isBenefits() ? amount.multiply(BigDecimal.valueOf(1 - BENEFIT_DISCOUNT)) : amount;
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
