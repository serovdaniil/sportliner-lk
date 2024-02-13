package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.Tariff;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserAuthority;
import by.sportliner.lk.core.security.AuthenticationRequest;
import by.sportliner.lk.core.security.AuthenticationService;
import by.sportliner.lk.core.service.ChildService;
import by.sportliner.lk.core.service.CurrentUserService;
import by.sportliner.lk.endpoint.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class AccountApiController implements AccountApi {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private ChildService childService;

    @Override
    public ResponseEntity<Void> changeCurrentUserPassword(AuthChangePasswordDto authChangePasswordDto) {
        String username = authChangePasswordDto.getUsername();
        String oldPassword = authChangePasswordDto.getOldPassword();
        String newPassword = authChangePasswordDto.getNewPassword();

        try {
            authenticationService.changePassword(
                new AuthenticationRequest(username, oldPassword, Set.of(UserAuthority.ACCESS_APPLICATION)),
                newPassword
            );
        } catch (AuthenticationException e) {
            throw new AccessDeniedException("Not authenticated for changing password", e);
        }

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserProfileDto> getCurrentUserProfile() {
        UserAccount userAccount = targetUser();
        List<Child> children = childService.findChildrenByParent(userAccount);

        return ResponseEntity.ok(new UserProfileDto()
            .id(userAccount.getId())
            .username(userAccount.getUsername())
            .email(userAccount.getEmail())
            .phone(userAccount.getPhone())
            .firstName(userAccount.getFirstName())
            .patronymic(userAccount.getPatronymic())
            .lastName(userAccount.getLastName())
            .children(children.stream()
                .map(it -> new ChildInfoDto()
                    .id(it.getId())
                    .fullName(it.getFullName())
                )
                .toList()
            )
        );
    }

    @Override
    public ResponseEntity<ChildProfileDto> getChildTargetAccount(String id) {
        Child child = childService.getChildById(id);

        return ResponseEntity.ok(new ChildProfileDto()
            .id(child.getId())
            .fullName(child.getFullName())
            .birthdate(child.getBirthday())
            .diagnosis(child.getDiagnosis())
            .tuitionBalance(child.getTuitionBalance())
            .tariff(TariffDto.valueOf(child.getTariff().name()))
            .notes(child.getNotes())
        );
    }

    @Override
    public ResponseEntity<Void> updateChildTargetAccount(String id, ChildProfileDto childProfileDto) {
        Child child = childService.getChildById(id);

        child.setTariff(Tariff.valueOf(childProfileDto.getTariff().name()));
        child.setDiagnosis(childProfileDto.getDiagnosis());
        child.setNotes(childProfileDto.getNotes());

        childService.save(child);

        return ResponseEntity.ok().build();
    }

    private UserAccount targetUser() {
        return currentUserService.getTargetUserAccount();
    }
}
