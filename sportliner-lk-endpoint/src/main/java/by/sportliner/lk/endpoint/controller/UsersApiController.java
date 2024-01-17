package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.PaymentType;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.ChildService;
import by.sportliner.lk.core.service.UserAccountCriteria;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.endpoint.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersApiController implements UsersApi {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private BranchOfficeService branchOfficeService;

    @Autowired
    private ChildService childService;

    @Override
    public ResponseEntity<Void> createUser(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();

        updateFields(userAccountDto, userAccount);

        List<Child> children = convert(userAccount, userAccountDto.getChildren());

        userAccountService.saveWithChildren(userAccount, children);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserAccountDto> getUserAccount(String id) {
        UserAccount userAccount = userAccountService.getById(id);
        List<Child> children = childService.findChildrenByParent(userAccount);

        return ResponseEntity.ok(new UserAccountDto()
            .id(userAccount.getId())
            .username(userAccount.getUsername())
            .passwordMustBeChanged(userAccount.isPasswordMustBeChanged())
            .role(UserRoleDto.fromValue(userAccount.getRole().name()))
            .email(userAccount.getEmail())
            .phone(userAccount.getPhone())
            .firstName(userAccount.getFirstName())
            .patronymic(userAccount.getPatronymic())
            .lastName(userAccount.getLastName())
            .children(children.stream()
                .map(it -> new ChildDto()
                    .id(it.getId())
                    .lastName(it.getLastName())
                    .firstName(it.getFirstName())
                    .patronymic(it.getPatronymic())
                    .birthdate(it.getBirthday())
                    .diagnosis(it.getDiagnosis())
                    .branchOffice(new BranchOfficeItemDto()
                        .id(it.getBranchOffice().getId())
                        .address(it.getBranchOffice().getAddress().getFullAddress())
                    )
                    .tuitionBalance(it.getTuitionBalance())
                    .numberClassesPerMonth(it.getNumberClassesPerMonth())
                    .paymentType(PaymentTypeDto.valueOf(it.getPaymentType().name()))
                    .notes(it.getNotes())
                )
                .toList()
            )
            .payAttention(userAccount.isPayAttention())
            .reason(userAccount.getReason())
            .createTimestamp(userAccount.getCreateTimestamp())
            .updateTimestamp(userAccount.getUpdateTimestamp())
            .loginTimestamp(userAccount.getLoginTimestamp())
        );
    }

    @Override
    public ResponseEntity<List<UserAccountListItemDto>> getUsers(UserAccountCriteriaDto criteria) {
        UserAccountCriteria userAccountCriteria = convert(criteria);

        return ResponseEntity.ok(userAccountService.findAll(userAccountCriteria).stream()
            .map(userAccount -> new UserAccountListItemDto()
                .id(userAccount.getId())
                .username(userAccount.getUsername())
                .fullName(userAccount.getFullName())
                .role(UserRoleDto.fromValue(userAccount.getRole().name()))
                .email(userAccount.getEmail())
                .phone(userAccount.getPhone())
            )
            .toList()
        );
    }

    @Override
    public ResponseEntity<Void> updateUserAccount(String id, UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountService.getById(id);

        updateFields(userAccountDto, userAccount);

        List<Child> children = convert(userAccount, userAccountDto.getChildren());

        userAccountService.saveWithChildren(userAccount, children);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userAccountService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    private void updateFields(UserAccountDto dto, UserAccount target) {
        if (dto.getPassword() != null) {
            target.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(dto.getPassword()));
            target.setPasswordMustBeChanged(true);
            target.setPasswordTimestamp(Instant.now());
        }

        target.setUsername(dto.getUsername());
        target.setRole(UserRole.valueOf(dto.getRole().name()));
        target.setLastName(dto.getLastName());
        target.setFirstName(dto.getFirstName());
        target.setPatronymic(dto.getPatronymic());
        target.setPhone(dto.getPhone());
        target.setEmail(dto.getEmail());
        target.setPayAttention(dto.isPayAttention());
        target.setReason(dto.getReason());
    }

    private List<Child> convert(UserAccount parent, List<ChildDto> childrenDto) {
        if (childrenDto == null) {
            return List.of();
        }

        return childrenDto.stream()
            .map(it -> {
                Child child = it.getId() == null
                    ? new Child()
                    : childService.getChildById(it.getId());

                child.setLastName(it.getLastName());
                child.setFirstName(it.getFirstName());
                child.setPatronymic(it.getPatronymic());
                child.setBirthday(it.getBirthdate());
                child.setDiagnosis(it.getDiagnosis());
                child.setNotes(it.getNotes());
                child.setParent(parent);
                child.setBranchOffice(branchOfficeService.getById(it.getBranchOffice().getId()));
                child.setTuitionBalance(it.getTuitionBalance());
                child.setNumberClassesPerMonth(it.getNumberClassesPerMonth());
                child.setPaymentType(PaymentType.valueOf(it.getPaymentType().name()));

                return child;
            }).collect(Collectors.toList());
    }

    private UserAccountCriteria convert(UserAccountCriteriaDto criteriaDto) {
        UserAccountCriteria criteria = new UserAccountCriteria();

        criteria.setLastName(criteriaDto.getLastName());
        criteria.setRole(criteriaDto.getRole() != null ? UserRole.valueOf(criteriaDto.getRole().name()) : null);
        criteria.setPayAttention(criteriaDto.isPayAttention());

        return criteria;
    }

}
