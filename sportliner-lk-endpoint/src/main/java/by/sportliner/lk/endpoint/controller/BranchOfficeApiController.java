package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.ClassSchedule;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.endpoint.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.List;

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
            .trainer(new UserAccountItemDto()
                .id(branchOffice.getTrainer().getId())
                .fullName(branchOffice.getTrainer().getFullName())
            )
            .classSchedules(branchOffice.getClassSchedules().stream()
                .map(it -> new ClassScheduleDto()
                    .day(DayOfWeekDto.valueOf(it.getDay().name()))
                    .time(it.getTime())
                )
                .toList()
            )
        );
    }

    @Override
    public ResponseEntity<List<BranchOfficeListItemDto>> getBranchOffices() {
        return ResponseEntity.ok(branchOfficeService.getAllBranchOffices().stream()
            .map(it -> new BranchOfficeListItemDto()
                .id(it.getId())
                .name(it.getName())
                .address(it.getAddress().getFullAddress())
            )
            .toList()
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
        target.setTrainer(userAccountService.getUserAccountById(dto.getTrainer().getId()));

        BranchOffice.BranchOfficeAddress address = new BranchOffice.BranchOfficeAddress();

        address.setCity(dto.getAddress().getCity());
        address.setStreet(dto.getAddress().getStreet());
        address.setBuildingNumber(dto.getAddress().getBuildingNumber());

        target.setAddress(address);

        target.getClassSchedules().clear();
        target.getClassSchedules().addAll(dto.getClassSchedules().stream()
            .map(it -> {
                ClassSchedule classSchedule = new ClassSchedule();

                classSchedule.setDay(DayOfWeek.valueOf(it.getDay().name()));
                classSchedule.setTime(it.getTime());

                return classSchedule;
            })
            .toList()
        );
    }
}
