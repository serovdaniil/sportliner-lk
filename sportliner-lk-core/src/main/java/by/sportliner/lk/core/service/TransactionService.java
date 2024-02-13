package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.Transaction;

public interface TransactionService {

    Transaction addNewTransactionForChild(Child child);

    Transaction addTransactionForNewChild(Child child);

}
