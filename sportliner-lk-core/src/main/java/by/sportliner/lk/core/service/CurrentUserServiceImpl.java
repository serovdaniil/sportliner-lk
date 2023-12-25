package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.UserAccountRepository;
import by.sportliner.lk.core.security.JwtMeta;
import by.sportliner.lk.core.security.UserDetailsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * {@link CurrentUserService} implementation.
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public String getUserId() {
        Authentication authentication = getCurrentAuthentication();

        return extractUserId(authentication);
    }

    @Override
    @Transactional
    public UserAccount getUserAccount() {
        return repository.getOne(getUserId());
    }

    @Override
    @Transactional
    public UserAccount getTargetUserAccount() {
        Authentication authentication = getCurrentAuthentication();
        UserAccount currentUser = getUserAccount();

        String targetUserId = extractTargetUser(authentication);
        if (targetUserId == null) {
            return currentUser;
        }

        return repository.getById(targetUserId);
    }

    private Authentication getCurrentAuthentication() {
        Authentication authentication = getCurrentSecurityContext().getAuthentication();

        if (authentication == null) {
            throw new IllegalStateException("Authentication is absent in current context!");
        }

        if (!authentication.isAuthenticated()) {
            throw new IllegalStateException("Authentication is in 'not-authenticated' state in current context!");
        }

        return authentication;
    }

    private String extractUserId(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            throw new IllegalStateException("Authentication has no expected principal!");
        }

        if (principal instanceof Jwt) {
            JwtMeta jwt = new JwtMeta((Jwt) principal);
            String userId = jwt.getSubject();

            if (userId == null) {
                throw new IllegalStateException("JWT has no expected subject!");
            }

            return userId;
        }

        if (principal instanceof UserDetailsAdapter) {
            String userId = ((UserDetailsAdapter) principal).getUserId();

            if (userId == null) {
                throw new IllegalStateException("UserDetails has no expected userId!");
            }

            return userId;
        }

        throw new IllegalStateException("Could not extract userId from authentication object of type " + principal.getClass());
    }

    private String extractTargetUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            throw new IllegalStateException("Authentication has no expected principal!");
        }

        if (principal instanceof Jwt) {
            JwtMeta jwt = new JwtMeta((Jwt) principal);
            return jwt.getTargetSubject();
        }

        return null;
    }

    private SecurityContext getCurrentSecurityContext() {
        return SecurityContextHolder.getContext();
    }
}
