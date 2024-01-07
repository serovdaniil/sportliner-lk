package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface AttendanceService {

    List<Attendance> findByBranchOfficeAndDate(BranchOffice branchOffice, LocalDate date);

    List<Attendance> findByChildAndPeriod(Child child, YearMonth period);

    List<Attendance> findByChild(Child child);

    void saveAttendances(List<Attendance> attendances);
}
