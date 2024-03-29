package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import by.sportliner.lk.endpoint.api.CatalogApi;
import by.sportliner.lk.endpoint.api.UserAccountItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogApiController implements CatalogApi {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Override
    public ResponseEntity<List<UserAccountItemDto>> getTrainers() {
        return ResponseEntity.ok(userAccountService.getTrainers().stream()
            .map(it -> new UserAccountItemDto()
                .id(it.getId())
                .fullName(it.getFullName())
            )
            .toList()
        );
    }

    @Override
    public ResponseEntity<List<UserAccountItemDto>> getEmployees() {
        return ResponseEntity.ok(userAccountService.getEmployees().stream()
            .map(it -> new UserAccountItemDto()
                .id(it.getId())
                .fullName(it.getFullName())
            )
            .toList()
        );
    }

    @Override
    public ResponseEntity<List<BranchOfficeItemDto>> getAvailableBranchOffices() {
        return ResponseEntity.ok(branchOfficeService.findAll().stream()
            .map(it -> new BranchOfficeItemDto()
                .id(it.getId())
                .address(it.getAddress().getFullAddress())
            )
            .toList()
        );
    }
}
