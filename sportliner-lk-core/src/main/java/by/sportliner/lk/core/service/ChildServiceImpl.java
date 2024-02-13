package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.AttendanceRepository;
import by.sportliner.lk.core.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Child getChildById(String id) {
        return childRepository.getReferenceById(id);
    }

    @Override
    public List<Child> findAll() {
        return childRepository.findAll();
    }

    @Override
    public List<Child> findChildrenByParent(UserAccount parent) {
        return childRepository.findByParent(parent);
    }

    @Override
    public List<Child> findChildrenByBranchOffice(BranchOffice branchOffice) {
        return childRepository.findByBranchOffice(branchOffice);
    }

    @Override
    public void save(List<Child> children) {
        childRepository.saveAll(children);
    }

    @Override
    public void save(Child child) {
        childRepository.save(child);
    }

    @Override
    public List<Child> findWithPerLessonPaymentTypeAndAttendanceForDay(LocalDate date) {
        return attendanceRepository.findByDateAndPerLessonPaymentType(date);
    }

    @Override
    public void deleteByParent(UserAccount parent) {
        childRepository.deleteAllByParent(parent);
    }
}
