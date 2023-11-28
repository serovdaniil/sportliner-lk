package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAuthority;

import java.util.Set;

public class AuthenticationRequest {

    private final String username;

    private final String password;

    private final Set<UserAuthority> requiredAuthorities;

    public AuthenticationRequest(String username, String password, Set<UserAuthority> requiredAuthorities) {
        this.username = username;
        this.password = password;
        this.requiredAuthorities = requiredAuthorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserAuthority> getRequiredAuthorities() {
        return requiredAuthorities;
    }
}
