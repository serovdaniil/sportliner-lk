package by.sportliner.lk.core.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link by.sportliner.lk.core.model.TrialAttendance}.
 */
@Repository
public interface TrialAttendanceRepository extends JpaRepositoryImplementation<by.sportliner.lk.core.model.TrialAttendance, String> {

}
