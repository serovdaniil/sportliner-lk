package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for {@link Child}.
 */
@Repository
public interface ChildRepository extends JpaRepositoryImplementation<Child, String> {

    List<Child> findByParent(UserAccount parent);

    List<Child> findByBranchOffice(BranchOffice branchOffice);

    void deleteAllByParent(UserAccount parent);

}
