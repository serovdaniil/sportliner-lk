package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import by.sportliner.lk.core.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public List<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount getUserAccountById(String id) {
        return userAccountRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format("User with %s not found", id)));
    }

    @Override
    public List<UserAccount> getTrainers() {
        return userAccountRepository.findByRole(UserRole.TRAINER);
    }
}
