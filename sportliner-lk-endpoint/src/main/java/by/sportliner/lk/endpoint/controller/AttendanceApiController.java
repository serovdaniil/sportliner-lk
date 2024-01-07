package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.service.AttendanceService;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.ChildService;
import by.sportliner.lk.endpoint.api.AttendanceApi;
import by.sportliner.lk.endpoint.api.AttendanceDto;
import by.sportliner.lk.endpoint.api.ChildAttendanceDto;
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

        Map<Child, List<Attendance>> attendances = branchOfficeService.getChildrenAttendances(branchOffice, period);


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

        attendanceService.saveAttendances(attendances);

        return ResponseEntity.ok().build();
    }
}
