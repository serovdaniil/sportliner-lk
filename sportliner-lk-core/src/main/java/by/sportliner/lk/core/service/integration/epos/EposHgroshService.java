package by.sportliner.lk.core.service.integration.epos;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.Transaction;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionRecords;

import java.time.LocalDate;

public interface EposHgroshService {

    String createInvoiceFor(Child child);

    String updateInvoiceFor(String number, Transaction transaction);

    TransactionRecords findTransactionInvoices(LocalDate date);

}
