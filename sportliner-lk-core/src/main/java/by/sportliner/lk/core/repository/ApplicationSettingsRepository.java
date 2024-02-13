package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.ApplicationSettings;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link ApplicationSettings}.
 */
@Repository
public interface ApplicationSettingsRepository extends JpaRepositoryImplementation<ApplicationSettings, String> {

    Optional<ApplicationSettings> findById(String id);

}
