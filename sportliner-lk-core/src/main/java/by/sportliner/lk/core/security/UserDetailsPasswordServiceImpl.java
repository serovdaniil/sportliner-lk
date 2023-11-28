package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.UserAccountRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {

    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserAccount account = userAccountRepository
            .findByUsername(user.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found: '%s'", user.getUsername())));

        account.setPassword(newPassword);
        account = userAccountRepository.saveAndFlush(account);

        return new UserDetailsAdapter(account);
    }

}
