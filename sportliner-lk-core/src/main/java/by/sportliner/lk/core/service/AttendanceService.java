package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface AttendanceService {

    List<Attendance> findByBranchOfficeAndDate(BranchOffice branchOffice, LocalDate date);

    List<Attendance> findByChildAndPeriod(Child child, YearMonth period);

    List<Attendance> findByChild(Child child);

    Map<Child, List<Attendance>> findChildrenAttendances(BranchOffice branchOffice, YearMonth period);

    void saveAttendances(YearMonth period, List<Attendance> attendances);
}
