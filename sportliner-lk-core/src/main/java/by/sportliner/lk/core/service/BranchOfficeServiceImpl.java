package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.ClassSchedule;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    @Autowired
    private BranchOfficeRepository branchOfficeRepository;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private ChildService childService;

    @Override
    public List<BranchOffice> findAll() {
        return branchOfficeRepository.findAll().stream()
            .sorted(Comparator.comparing(it -> it.getAddress().getFullAddress()))
            .collect(Collectors.toList());
    }

    @Override
    public BranchOffice getById(String id) {
        return branchOfficeRepository.getReferenceById(id);
    }

    @Override
    public BranchOffice getByName(String name) {
        return branchOfficeRepository.findByName(name)
            .orElseThrow(() -> new IllegalArgumentException("The branch office not found by name: " + name));
    }

    @Override
    public BranchOffice getBranchOfficeOfCurrentTrainer() {
        UserAccount targetUser = currentUserService.getTargetUserAccount();

        if (!targetUser.isTrainer()) {
            throw new IllegalArgumentException("The current user is not a trainer");
        }

        return branchOfficeRepository.findByTrainer(targetUser)
            .orElseThrow(() -> new IllegalArgumentException("The trainer is not affiliated with an branch"));
    }

    @Override
    @Transactional
    public Map<LocalDate, List<LocalTime>> getClassSchedules(BranchOffice branchOffice, YearMonth period) {
        return generateScheduleForCurrentMonth(branchOffice, period);
    }

    @Override
    public List<Child> getChildren(BranchOffice branchOffice) {
        return childService.findChildrenByBranchOffice(branchOffice).stream()
            .sorted(Comparator.comparing(Child::getFullName))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BranchOffice save(BranchOffice branchOffice) {
        return branchOfficeRepository.save(branchOffice);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        branchOfficeRepository.deleteById(id);
    }

    private Map<LocalDate, List<LocalTime>> generateScheduleForCurrentMonth(BranchOffice branchOffice,
                                                                            YearMonth period) {
        Map<DayOfWeek, List<ClassSchedule>> classSchedules = branchOffice.getClassSchedules().stream()
            .collect(Collectors.groupingBy(ClassSchedule::getDay));

        if (classSchedules.isEmpty()) {
            return Map.of();
        }

        Map<LocalDate, List<LocalTime>> schedules = new HashMap<>();

        for (int i = 0; i < period.lengthOfMonth(); i++) {
            LocalDate date = period.atDay(i + 1); // add 1 to get the current date
            DayOfWeek day = date.getDayOfWeek();

            if (!classSchedules.containsKey(day)) {
                continue;
            }

            List<LocalTime> timesForDate = classSchedules.get(day).stream()
                .map(ClassSchedule::getTime)
                .sorted()
                .collect(Collectors.toList());

            schedules.put(date, timesForDate);
        }

        return schedules;
    }
}
