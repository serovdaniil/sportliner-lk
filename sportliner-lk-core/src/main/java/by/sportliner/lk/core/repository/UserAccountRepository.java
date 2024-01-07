package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link UserAccount}.
 */
@Repository
public interface UserAccountRepository extends JpaRepositoryImplementation<UserAccount, String> {

    Optional<UserAccount> findByUsername(String username);

    Optional<UserAccount> findById(String id);

    List<UserAccount> findByRole(UserRole role);

    @Modifying
    @Query("update UserAccount u set u.loginTimestamp = :timestamp where u.id = :id")
    void updateLoginTimestamp(@Param(value = "id") String id, @Param(value = "timestamp") Instant timestamp);
}
