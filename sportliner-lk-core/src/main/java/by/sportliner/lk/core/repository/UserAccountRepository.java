package by.sportliner.lk.core.repository;
import by.sportliner.lk.core.model.UserAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepositoryImplementation<UserAccount, String> {

    Optional<UserAccount> findByUsername(String username);
}
