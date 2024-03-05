package by.sportliner.lk.core.service.email;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.PayingEntity;
import by.sportliner.lk.core.model.Transaction;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class UpdatedInvoicesData {

    private List<Transaction> transactions;

    private List<String> recipients = List.of("mihalenya80@mail.ru", "daniils3rov@yandex.by");

    public UpdatedInvoicesData() {
    }

    public UpdatedInvoicesData data(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return transactions.stream()
            .map(Transaction::getInvoiceAmount)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Pair<BranchOffice, BigDecimal>> getSportlinerTransactionsByBranchOffice() {
        return findTransactionByPayingEntity(PayingEntity.SPORTLINER).stream()
            .collect(Collectors.groupingBy(it -> it.getChild().getBranchOffice()))
            .entrySet()
            .stream()
            .map(entry -> {
                BigDecimal total = entry.getValue().stream()
                    .map(Transaction::getInvoiceAmount)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

                return Pair.of(entry.getKey(), total);
            })
            .collect(Collectors.toList());
    }

    public List<Pair<BranchOffice, BigDecimal>> getMichaleniaTransactionsByBranchOffice() {
        return findTransactionByPayingEntity(PayingEntity.MICHALENIA).stream()
            .collect(Collectors.groupingBy(it -> it.getChild().getBranchOffice()))
            .entrySet()
            .stream()
            .map(entry -> {
                BigDecimal total = entry.getValue().stream()
                    .map(Transaction::getInvoiceAmount)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

                return Pair.of(entry.getKey(), total);
            })
            .collect(Collectors.toList());
    }

    private List<Transaction> findTransactionByPayingEntity(PayingEntity payingEntity) {
        return transactions.stream()
            .filter(it -> it.getChild().getPayingEntity().equals(payingEntity))
            .collect(Collectors.toList());
    }

}
