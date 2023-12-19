package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.BranchOffice;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link BranchOffice}.
 */
@Repository
public interface BranchOfficeRepository extends JpaRepositoryImplementation<BranchOffice, String> {

    Optional<BranchOffice> findById(String id);
}
