package by.sportliner.lk.core.service.integration.epos;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.Transaction;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionRecords;

import java.time.LocalDate;
import java.util.List;

public interface EposHgroshService {

    String createInvoiceFor(Child child);

    String updateInvoiceFor(String number, Transaction transaction);

    List<by.sportliner.lk.integration.epos.hgrosh.internal.api.Transaction> findTransactionInvoices(LocalDate date);

}
