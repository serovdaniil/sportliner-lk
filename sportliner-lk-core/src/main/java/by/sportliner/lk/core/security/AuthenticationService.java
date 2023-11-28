package by.sportliner.lk.core.security;

/**
 * Authentication service.
 */
public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse changePassword(AuthenticationRequest request, String newPassword);

    AuthenticationResponse refresh(String refreshToken);
}
