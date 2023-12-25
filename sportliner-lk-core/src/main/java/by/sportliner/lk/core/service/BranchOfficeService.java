package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface BranchOfficeService {

    List<BranchOffice> findAll();

    BranchOffice getById(String id);

    BranchOffice save(BranchOffice branchOffice);

    void deleteById(String id);

    BranchOffice getBranchOfficeOfCurrentTrainer();

    Map<LocalDate, List<LocalTime>> getClassSchedules(BranchOffice branchOffice, YearMonth period);

    Map<Child, List<Attendance>> getChildrenAttendances(BranchOffice branchOffice, YearMonth period);

    List<Child> getChildren(BranchOffice branchOffice);

}
