package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.analysis.AnalysisService;
import by.sportliner.lk.core.service.analysis.AttendancesAnalysis;
import by.sportliner.lk.endpoint.api.AnalysisApi;
import by.sportliner.lk.endpoint.api.AnalysisDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AnalysisApiController implements AnalysisApi {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Override
    public ResponseEntity<AnalysisDataDto> analysisDayAtBranchOffice(String branchOfficeId, LocalDate date) {
        BranchOffice branchOffice = branchOfficeService.getById(branchOfficeId);

        AttendancesAnalysis analysis = analysisService.analysisBranchOffice(branchOffice, date);

        return ResponseEntity.ok(new AnalysisDataDto()
            .averageAttendance(analysis.getAverageAttendance())
            .attendanceByTime(analysis.getAttendanceByTime().entrySet().stream()
                .collect(Collectors.toMap(
                    it -> it.getKey().toString(),
                    Map.Entry::getValue
                ))
            )
        );
    }
}
