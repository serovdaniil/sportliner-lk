package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> getUserAccounts();

    UserAccount getUserAccountById(String id);

    List<UserAccount> getTrainers();

    void deleteUserAccountById(String id);

    UserAccount saveUserAccountAndChildren(UserAccount userAccount, List<Child> children);

}
