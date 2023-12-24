package by.sportliner.lk.core.model;

import java.util.Set;

/**
 * User role in the system.
 */
public enum UserRole {

    /**
     * Administrator.
     */
    ADMIN(
        UserAuthority.AUTHENTICATED,
        UserAuthority.ACCESS_APPLICATION,
        UserAuthority.ADMINISTRATIVE,
        UserAuthority.TRAINER
    ),

    /**
     * Parent.
     */
    PARENT(
        UserAuthority.AUTHENTICATED,
        UserAuthority.ACCESS_APPLICATION,
        UserAuthority.PARENT
    ),

    /**
     * Trainer.
     */
    TRAINER(
        UserAuthority.AUTHENTICATED,
        UserAuthority.ACCESS_APPLICATION,
        UserAuthority.TRAINER
    ),

    /**
     * Customer.
     */
    CUSTOMER(
        UserAuthority.AUTHENTICATED
    );

    private final Set<UserAuthority> authorities;

    UserRole(UserAuthority... authorities) {
        this.authorities = Set.of(authorities);
    }

    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }
}
