package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.endpoint.api.UserAccountDto;
import by.sportliner.lk.endpoint.api.UserAccountListItemDto;
import by.sportliner.lk.endpoint.api.UserRoleDto;
import by.sportliner.lk.endpoint.api.UsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersApiController implements UsersApi {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public ResponseEntity<Void> createUser(UserAccountDto userAccountDto) {
        return null; //todo
    }

    @Override
    public ResponseEntity<UserAccountDto> getUserAccount(String id) {
        UserAccount userAccount = userAccountService.getUserAccountById(id);

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
            .createTimestamp(userAccount.getCreateTimestamp())
            .updateTimestamp(userAccount.getUpdateTimestamp())
            .loginTimestamp(userAccount.getLoginTimestamp())
        );
    }

    @Override
    public ResponseEntity<List<UserAccountListItemDto>> getUsers() {
        return ResponseEntity.ok(userAccountService.getUserAccounts().stream()
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
        return null; //todo
    }

}
