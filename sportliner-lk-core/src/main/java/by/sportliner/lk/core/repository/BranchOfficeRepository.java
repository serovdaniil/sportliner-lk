package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link BranchOffice}.
 */
@Repository
public interface BranchOfficeRepository extends JpaRepositoryImplementation<BranchOffice, String> {

    Optional<BranchOffice> findById(String id);
    @Query("select p from BranchOffice p left join p.classSchedules q where q.trainer = :trainer")
    Optional<BranchOffice> findByTrainer(UserAccount trainer);
}
