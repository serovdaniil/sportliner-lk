package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;

import java.time.LocalDate;
import java.util.List;

public interface ChildService {

    Child getChildById(String id);

    List<Child> findAll();

    List<Child> findChildrenByParent(UserAccount parent);

    List<Child> findChildrenByBranchOffice(BranchOffice branchOffice);

    void save(List<Child> children);

    void save(Child child);

    List<Child> findWithPerLessonPaymentTypeAndAttendanceForDay(LocalDate date);

    void deleteByParent(UserAccount parent);

}
