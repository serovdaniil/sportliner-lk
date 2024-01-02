package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository for {@link Attendance}.
 */
@Repository
public interface AttendanceRepository extends JpaRepositoryImplementation<Attendance, String> {
    @Query("select a from Attendance a inner join a.child q where q.branchOffice = :branchOffice AND a.date = :date")
    List<Attendance> findByBranchOfficeAndDate(BranchOffice branchOffice, LocalDate date);

    @Modifying
    @Query("SELECT st FROM Attendance st WHERE st.child = :child " +
        "AND :fromDate <= st.date AND st.date <= :toDate"
    )
    List<Attendance> findByChildAndPeriod(Child child, LocalDate fromDate, LocalDate toDate);

    @Modifying
    @Query("DELETE FROM Attendance st WHERE st.child = :child " +
        "AND :fromDate <= st.date AND st.date <= :toDate"
    )
    int deleteAllByChildAndPeriod(Child child, LocalDate fromDate, LocalDate toDate);

}
