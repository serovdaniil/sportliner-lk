package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.Transaction;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository for {@link by.sportliner.lk.core.model.Transaction}.
 */
@Repository
public interface TransactionRepository extends JpaRepositoryImplementation<Transaction, String> {

    List<Transaction> findAllByDate(LocalDate date);

    List<Transaction> findByStatus(Transaction.Status status);

}
