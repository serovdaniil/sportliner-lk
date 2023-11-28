package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link UserDetails} implementation.
 */
public class UserDetailsAdapter extends User implements UserDetails {

    private final String userId;

    private final UserAccount account;

    public UserDetailsAdapter(UserAccount account) {
        super(
            account.getUsername(),
            account.getPassword(),
            true,
            true,
            true,
            true,
            collectAuthoritiesFromRole(account.getRole())
        );

        this.userId = account.getId();
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public UserAccount getAccount() {
        return account;
    }

    private static Collection<? extends GrantedAuthority> collectAuthoritiesFromRole(UserRole role) {
        List<SimpleGrantedAuthority> result = new ArrayList<>();

        result.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

        result.addAll(role.getAuthorities().stream()
            .map(it -> new SimpleGrantedAuthority("SCOPE_" + it.name()))
            .collect(Collectors.toList())
        );

        return result;
    }
}
