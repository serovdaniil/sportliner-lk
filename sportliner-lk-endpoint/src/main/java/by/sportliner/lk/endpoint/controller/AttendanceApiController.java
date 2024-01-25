package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.TrialAttendance;
import by.sportliner.lk.core.service.AttendanceService;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.ChildService;
import by.sportliner.lk.endpoint.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AttendanceApiController implements AttendanceApi {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ChildService childService;

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Override
    public ResponseEntity<List<ChildAttendanceDto>> getAttendancesForBranchOffice(String branchOfficeId, YearMonth period) {
        BranchOffice branchOffice = branchOfficeService.getById(branchOfficeId);

        Map<Child, List<Attendance>> attendances = attendanceService.findChildrenAttendances(branchOffice, period);


        return ResponseEntity.ok(attendances.entrySet().stream()
            .map(entry -> new ChildAttendanceDto()
                .childId(entry.getKey().getId())
                .attendances(entry.getValue().stream()
                    .map(attendance -> new AttendanceDto()
                        .date(attendance.getDate())
                        .time(attendance.getTime())
                    )
                    .collect(Collectors.toList())
                )
            )
            .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<List<AttendanceDto>> getAttendancesForChild(String childId) {
        Child child = childService.getChildById(childId);
        List<Attendance> attendances = attendanceService.findByChild(child);

        return ResponseEntity.ok(attendances.stream()
            .map(it -> new AttendanceDto()
                .date(it.getDate())
                .time(it.getTime())
            )
            .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<Void> saveAttendances(String branchOfficeId,
                                                YearMonth period,
                                                List<ChildAttendanceDto> childAttendanceDto) {
        List<Attendance> attendances = childAttendanceDto.stream()
            .map(item -> {
                Child child = childService.getChildById(item.getChildId());

                return item.getAttendances().stream()
                    .map(it -> {
                        Attendance attendance = new Attendance();

                        attendance.setChild(child);
                        attendance.setDate(it.getDate());
                        attendance.setTime(it.getTime());

                        return attendance;
                    })
                    .collect(Collectors.toList());
            })
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        BranchOffice branchOffice = branchOfficeService.getById(branchOfficeId);

        attendanceService.saveAttendances(branchOffice, period, attendances);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> confirmTrialAttendance(String trialAttendanceId) {
        attendanceService.confirmAttendance(trialAttendanceId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> createTrialAttendances(TrialAttendanceDto trialAttendanceDto) {
        TrialAttendance trialAttendance = convert(trialAttendanceDto);

        attendanceService.addNewTrialAttendance(trialAttendance);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<TrialAttendanceDto>> getTrialAttendances() {
        return ResponseEntity.ok(attendanceService.findTrialAttendances().stream()
            .map(it -> new TrialAttendanceDto()
                .id(it.getId())
                .branchOffice(new BranchOfficeItemDto()
                    .id(it.getId())
                    .address(it.getBranchOffice().getAddress().getFullAddress())
                )
                .name(it.getName())
                .phone(it.getPhone())
                .diagnosis(it.getDiagnosis())
                .date(it.getDate())
                .status(TrialAttendanceStatusDto.valueOf(it.getTrialAttendanceStatus().name()))
            )
            .collect(Collectors.toList())
        );
    }

    private TrialAttendance convert(TrialAttendanceDto dto) {
        TrialAttendance trialAttendance = new TrialAttendance();

        trialAttendance.setBranchOffice(branchOfficeService.getById(dto.getBranchOffice().getId()));
        trialAttendance.setName(dto.getName());
        trialAttendance.setPhone(dto.getPhone());
        trialAttendance.setDiagnosis(dto.getDiagnosis());
        trialAttendance.setDate(dto.getDate());
        trialAttendance.setTrialAttendanceStatus(TrialAttendance.TrialAttendanceStatus.UNATTENDED);

        return trialAttendance;
    }
}
