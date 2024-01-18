package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.TrialAttendance;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for {@link by.sportliner.lk.core.model.TrialAttendance}.
 */
@Repository
public interface TrialAttendanceRepository extends JpaRepositoryImplementation<by.sportliner.lk.core.model.TrialAttendance, String> {

    List<TrialAttendance> findByBranchOffice(BranchOffice branchOffice);

}
