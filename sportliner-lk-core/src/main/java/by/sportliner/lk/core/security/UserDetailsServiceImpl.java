package by.sportliner.lk.core.security;

import by.sportliner.lk.core.repository.UserAccountRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * {@link UserDetailsService} implementation.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username, "username");

        return userAccountRepository.findByUsername(username)
            .map(UserDetailsAdapter::new)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found: %s", username)));
    }
}
