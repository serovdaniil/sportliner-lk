package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Child;
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

        userAccount.setUsername(userAccountDto.getUsername());
        userAccount.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userAccountDto.getPassword()));
        userAccount.setPasswordMustBeChanged(true);
        userAccount.setPasswordTimestamp(Instant.now());
        userAccount.setRole(UserRole.valueOf(userAccountDto.getRole().name()));
        userAccount.setLastName(userAccountDto.getLastName());
        userAccount.setFirstName(userAccountDto.getFirstName());
        userAccount.setPatronymic(userAccountDto.getPatronymic());
        userAccount.setPhone(userAccountDto.getPhone());
        userAccount.setEmail(userAccountDto.getEmail());
        userAccount.setCreateTimestamp(Instant.now());
        userAccount.setPayAttention(userAccountDto.isPayAttention());
        userAccount.setReason(userAccountDto.getReason());

        List<Child> children = convert(userAccount, userAccountDto.getChildren());

        userAccountService.saveUserAccountAndChildren(userAccount, children);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserAccountDto> getUserAccount(String id) {
        UserAccount userAccount = userAccountService.getUserAccountById(id);
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

        return ResponseEntity.ok(userAccountService.getUserAccounts(userAccountCriteria).stream()
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
        UserAccount userAccount = userAccountService.getUserAccountById(id);

        if (userAccountDto.getPassword() != null) {
            userAccount.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userAccountDto.getPassword()));
            userAccount.setPasswordMustBeChanged(true);
            userAccount.setPasswordTimestamp(Instant.now());
        }

        userAccount.setRole(UserRole.valueOf(userAccountDto.getRole().name()));
        userAccount.setLastName(userAccountDto.getLastName());
        userAccount.setFirstName(userAccountDto.getFirstName());
        userAccount.setPatronymic(userAccountDto.getPatronymic());
        userAccount.setPhone(userAccountDto.getPhone());
        userAccount.setEmail(userAccountDto.getEmail());
        userAccount.setPayAttention(userAccountDto.isPayAttention());
        userAccount.setReason(userAccountDto.getReason());
        userAccount.setUpdateTimestamp(Instant.now());

        List<Child> children = convert(userAccount, userAccountDto.getChildren());

        userAccountService.saveUserAccountAndChildren(userAccount, children);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userAccountService.deleteUserAccountById(id);

        return ResponseEntity.ok().build();
    }

    private List<Child> convert(UserAccount parent, List<ChildDto> childrenDto) {
        if (childrenDto == null) {
            return List.of();
        }

        return childrenDto.stream()
            .map(it -> {
                Child child = it.getId() == null
                    ? new Child()
                    : childService.findChildById(it.getId());

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
