package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.Child;

import java.time.YearMonth;
import java.util.List;

public interface AttendanceService {

    List<Attendance> findByChildAndPeriod(Child child, YearMonth period);

    void saveAttendances(List<Attendance> attendances);
}
