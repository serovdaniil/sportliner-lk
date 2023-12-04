package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.UserAccount;
import org.apache.catalina.User;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> getUserAccounts();

    UserAccount getUserAccountById(String id);

    List<UserAccount> getTrainers();

}
