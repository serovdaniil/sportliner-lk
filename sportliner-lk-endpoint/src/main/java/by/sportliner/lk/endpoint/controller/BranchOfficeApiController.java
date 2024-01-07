package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.ClassSchedule;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.endpoint.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BranchOfficeApiController implements BranchOfficeApi {

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public ResponseEntity<Void> createBranchOffice(BranchOfficeDto branchOfficeDto) {
        BranchOffice branchOffice = new BranchOffice();

        updateFields(branchOffice, branchOfficeDto);

        branchOfficeService.save(branchOffice);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BranchOfficeDto> getBranchOffice(String id) {
        BranchOffice branchOffice = branchOfficeService.getById(id);

        return ResponseEntity.ok(new BranchOfficeDto()
            .id(branchOffice.getId())
            .name(branchOffice.getName())
            .address(new BranchOfficeAddressDto()
                .city(branchOffice.getAddress().getCity())
                .street(branchOffice.getAddress().getStreet())
                .buildingNumber(branchOffice.getAddress().getBuildingNumber())
            )
            .classSchedules(branchOffice.getClassSchedules().stream()
                .map(it -> new ClassScheduleDto()
                    .day(DayOfWeekDto.valueOf(it.getDay().name()))
                    .time(it.getTime())
                    .trainer(new UserAccountItemDto()
                        .id(it.getTrainer().getId())
                        .fullName(it.getTrainer().getFullName())
                    )
                )
                .toList()
            )
        );
    }

    @Override
    public ResponseEntity<List<BranchOfficeListItemDto>> getBranchOffices() {
        return ResponseEntity.ok(branchOfficeService.findAll().stream()
            .map(it -> new BranchOfficeListItemDto()
                .id(it.getId())
                .name(it.getName())
                .address(it.getAddress().getFullAddress())
            )
            .toList()
        );
    }

    @Override
    public ResponseEntity<BranchOfficeItemDto> getBranchOfficeOfCurrentTrainer() {
        BranchOffice branchOffice = branchOfficeService.getBranchOfficeOfCurrentTrainer();

        return ResponseEntity.ok(new BranchOfficeItemDto()
            .id(branchOffice.getId())
            .address(branchOffice.getAddress().getFullAddress())
        );
    }

    @Override
    public ResponseEntity<Map<String, List<LocalTime>>> getSchedulesForBranchOffice(String id, YearMonth period) {
        BranchOffice branchOffice = branchOfficeService.getById(id);

        Map<LocalDate, List<LocalTime>> schedules = branchOfficeService.getClassSchedules(branchOffice, period);

        return ResponseEntity.ok(schedules.entrySet().stream()
            .collect(Collectors.toMap(
                it -> it.getKey().toString(),
                Map.Entry::getValue
            ))
        );
    }

    @Override
    public ResponseEntity<List<ChildInfoDto>> getChildrenForBranchOffice(String id) {
        BranchOffice branchOffice = branchOfficeService.getById(id);

        List<Child> children = branchOfficeService.getChildren(branchOffice);

        return ResponseEntity.ok(children.stream()
            .map(it -> new ChildInfoDto()
                .id(it.getId())
                .fullName(it.getFullName())
            )
            .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<Void> updateBranchOffice(String id, BranchOfficeDto branchOfficeDto) {
        BranchOffice branchOffice = branchOfficeService.getById(id);

        updateFields(branchOffice, branchOfficeDto);

        branchOfficeService.save(branchOffice);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteBranchOffice(String id) {
        branchOfficeService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    private void updateFields(BranchOffice target, BranchOfficeDto dto) {
        target.setName(dto.getName());

        BranchOffice.BranchOfficeAddress address = new BranchOffice.BranchOfficeAddress();

        address.setCity(dto.getAddress().getCity());
        address.setStreet(dto.getAddress().getStreet());
        address.setBuildingNumber(dto.getAddress().getBuildingNumber());

        target.setAddress(address);

        if (target.getClassSchedules() == null) {
            target.setClassSchedules(new ArrayList<>());
        }

        target.getClassSchedules().clear();
        target.getClassSchedules().addAll(dto.getClassSchedules().stream()
            .map(it -> {
                ClassSchedule classSchedule = new ClassSchedule();

                classSchedule.setDay(DayOfWeek.valueOf(it.getDay().name()));
                classSchedule.setTime(it.getTime());
                classSchedule.setTrainer(userAccountService.getById(it.getTrainer().getId()));

                return classSchedule;
            })
            .toList()
        );
    }
}
