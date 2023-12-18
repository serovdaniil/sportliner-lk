package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import by.sportliner.lk.core.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private ChildService childService;

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

    @Override
    @Transactional
    public void deleteUserAccountById(String id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserAccount saveUserAccountAndChildren(UserAccount userAccount, List<Child> children) {
        UserAccount target = userAccountRepository.save(userAccount);

        childService.deleteByParent(target);
        childService.saveChildren(children);

        return target;
    }
}
