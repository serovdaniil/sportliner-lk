package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepositoryImplementation<Child, String> {

    List<Child> findByParent(UserAccount parent);

    void deleteAllByParent(UserAccount parent);

}
