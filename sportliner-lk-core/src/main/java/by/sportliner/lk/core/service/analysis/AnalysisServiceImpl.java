package by.sportliner.lk.core.service.analysis;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AttendanceService attendanceService;

    @Override
    public AttendancesAnalysis analysisBranchOffice(BranchOffice branchOffice, LocalDate date) {
        return analysisBranchOfficeForRange(branchOffice, date, date)
            .get(date);
    }

    @Override
    public Map<LocalDate, AttendancesAnalysis> analysisBranchOfficeForRange(BranchOffice branchOffice,
                                                                            LocalDate from,
                                                                            LocalDate to) {
        return from.datesUntil(to.plusDays(1))
            .map(date -> {
                Map<LocalTime, List<Attendance>> attendances =
                    attendanceService.findByBranchOfficeAndDate(branchOffice, date).stream()
                        .collect(Collectors.groupingBy(Attendance::getTime));

                if (attendances.isEmpty()) {
                    return Map.entry(date, getEmptyAttendancesAnalysis());
                }

                BigDecimal countAttendances = attendances.values().stream()
                    .map(List::size)
                    .map(BigDecimal::new)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

                AttendancesAnalysis analysis = new AttendancesAnalysis();

                analysis.setAverageAttendance(
                    countAttendances.divide(BigDecimal.valueOf(attendances.size()), 2, RoundingMode.HALF_UP)
                );
                analysis.setAttendanceByTime(attendances.entrySet().stream()
                    .map(entry -> Map.entry(entry.getKey(), entry.getValue().size()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                );

                return Map.entry(date, analysis);
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private AttendancesAnalysis getEmptyAttendancesAnalysis() {
        AttendancesAnalysis analysis = new AttendancesAnalysis();

        analysis.setAverageAttendance(BigDecimal.ZERO);
        analysis.setAttendanceByTime(Map.of());

        return analysis;
    }

}
