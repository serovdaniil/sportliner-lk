package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> findAll(UserAccountCriteria criteria);


    List<UserAccount> findAllAdmin();

    UserAccount getById(String id);

    List<UserAccount> getTrainers();

    List<UserAccount> getEmployees();

    void deleteById(String id);

    UserAccount saveWithChildren(UserAccount userAccount, List<Child> children);

}
