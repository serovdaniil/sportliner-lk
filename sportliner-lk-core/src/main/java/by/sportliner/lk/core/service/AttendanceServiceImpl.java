package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.*;
import by.sportliner.lk.core.repository.AttendanceRepository;
import by.sportliner.lk.core.repository.ChildRepository;
import by.sportliner.lk.core.repository.TrialAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private TrialAttendanceRepository trialAttendanceRepository;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Override
    public List<Attendance> findByBranchOfficeAndDate(BranchOffice branchOffice, LocalDate date) {
        return attendanceRepository.findByBranchOfficeAndDate(branchOffice, date);
    }

    @Override
    public List<Attendance> findByChildAndPeriod(Child child, YearMonth period) {
        return attendanceRepository.findByChildAndPeriod(child, period.atDay(1), period.atEndOfMonth());
    }

    @Override
    public List<Attendance> findByChild(Child child) {
        return attendanceRepository.findByChild(child).stream()
            .sorted(Comparator.comparing(Attendance::getDate).reversed())
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Map<Child, List<Attendance>> findChildrenAttendances(BranchOffice branchOffice, YearMonth period) {
        List<Child> children = childRepository.findByBranchOffice(branchOffice);

        return children.stream()
            .map(child -> Map.entry(child, findByChildAndPeriod(child, period)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    @Transactional
    public void saveAttendances(YearMonth period, List<Attendance> attendances) {
        LocalDate fromDate = period.atDay(1);
        LocalDate toDate = period.atEndOfMonth();

        Map<Child, List<Attendance>> attendancesByChild = attendances.stream()
            .collect(Collectors.groupingBy(Attendance::getChild));

        for (Map.Entry<Child, List<Attendance>> entry : attendancesByChild.entrySet()) {
            Child child = entry.getKey();
            List<Attendance> attendancesForChild = entry.getValue();

            int count = attendanceRepository.deleteAllByChildAndPeriod(child, fromDate, toDate);

            child.minusFewClasses(attendancesForChild.size() - count);

            attendanceRepository.saveAll(attendancesForChild);
            childRepository.save(child);
        }
    }

    @Override
    public List<TrialAttendance> findTrialAttendances() {
        UserAccount currentUserAccount = currentUserService.getUserAccount();

        if (currentUserAccount.isTrainer()) {
            BranchOffice branchOffice = branchOfficeService.getBranchOfficeOfCurrentTrainer();

            return trialAttendanceRepository.findByBranchOffice(branchOffice);
        }

        return trialAttendanceRepository.findAll();
    }

    @Override
    public void addNewTrialAttendance(TrialAttendance trialAttendance) {
        trialAttendanceRepository.save(trialAttendance);
    }

    @Override
    public void confirmAttendance(String trialAttendanceId) {
        TrialAttendance trialAttendance = trialAttendanceRepository.getReferenceById(trialAttendanceId);

        trialAttendance.setTrialAttendanceStatus(TrialAttendance.TrialAttendanceStatus.ATTENDED);

        trialAttendanceRepository.save(trialAttendance);
    }
}
