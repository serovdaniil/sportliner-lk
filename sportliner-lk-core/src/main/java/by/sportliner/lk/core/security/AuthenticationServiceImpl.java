package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    private static final String AUTH_TOKEN_TYPE = "bearer";
    private static final int AUTH_TOKEN_TTL = (int) TimeUnit.MINUTES.toSeconds(5);
    private static final int REF_TOKEN_TTL = (int) TimeUnit.MINUTES.toSeconds(30);
    private static final int SESSION_TIMEOUT = (int) TimeUnit.MINUTES.toSeconds(15);

    @Autowired
    @Qualifier("userCredentialsAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserAccount account = checkCredentials(request);

        return onSuccessAuth(account, true);
    }

    @Override
    public AuthenticationResponse changePassword(AuthenticationRequest request, String newPassword) {
        UserAccount account = checkCredentials(request);

        account.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(newPassword));
        account.setPasswordTimestamp(Instant.now());

        userAccountRepository.saveAndFlush(account);

        return onSuccessAuth(account, true);
    }

    @Override
    public AuthenticationResponse refresh(String refreshToken) {
        Jwt token;
        try {
            token = jwtService.decode(refreshToken);
        }
        catch (JwtException e) {
            throw new InsufficientAuthenticationException("Invalid refresh token", e);
        }

        String userId = token.getSubject();
        UserAccount account = userAccountRepository.getOne(userId);

        return onSuccessAuth(account, false);
    }

    private UserAccount checkCredentials(AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken credentials =
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authenticationProvider.authenticate(credentials);

        UserDetailsAdapter userDetails = (UserDetailsAdapter) authentication.getPrincipal();
        UserAccount account = userDetails.getAccount();

        if (!account.getRole().getAuthorities().containsAll(request.getRequiredAuthorities())) {
            throw new AccessDeniedException("User doesn't have any applicable authorities!");
        }

        return account;
    }

    private AuthenticationResponse onSuccessAuth(UserAccount account, boolean updateTimestamp) {
        if (updateTimestamp) {
            // userAccountRepository.updateLoginTimestamp(account.getId(), Instant.now());
            LOGGER.debug("Authenticated as: {}", account.getUsername());
        }

        String token = jwtService.create(account, AUTH_TOKEN_TTL);
        String refreshToken = jwtService.create(account, REF_TOKEN_TTL);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setStatus(AuthenticationResponse.Status.SUCCESS);
        response.setToken(new AuthToken(token, AUTH_TOKEN_TYPE, AUTH_TOKEN_TTL));
        response.setRefreshToken(new AuthToken(refreshToken, AUTH_TOKEN_TYPE, REF_TOKEN_TTL));
        response.setInfo(toAuthInfo(account));
        response.setSessionTimeout(SESSION_TIMEOUT);
        return response;
    }

    private AuthInfo toAuthInfo(UserAccount account) {
        AuthInfo result = new AuthInfo();

        result.setId(account.getId());
        result.setUsername(account.getUsername());
        result.setFirstName(account.getFirstName());
        result.setLastName(account.getLastName());
        result.setAuthorities(account.getRole().getAuthorities());

        return result;
    }
}
