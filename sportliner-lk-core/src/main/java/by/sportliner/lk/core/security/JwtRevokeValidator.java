package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;
import java.util.function.Function;

/**
 * Validator, that checks if JWT should be treated as revoked,
 * as account was blocked, expired or any specific grants were revoked.
 */
public class JwtRevokeValidator implements OAuth2TokenValidator<Jwt> {

    private final Function<String, Optional<UserAccount>> userAccountByIdProvider;

    public JwtRevokeValidator(Function<String, Optional<UserAccount>> userAccountByIdProvider) {
        this.userAccountByIdProvider = userAccountByIdProvider;
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        String userId = token.getSubject();

        if (userId == null) {
            return OAuth2TokenValidatorResult.failure(new OAuth2Error(OAuth2ErrorCodes.INVALID_TOKEN));
        }

        UserAccount account = userAccountByIdProvider.apply(userId).orElse(null);

        if (account == null) {
            return OAuth2TokenValidatorResult.failure(new OAuth2Error(OAuth2ErrorCodes.INVALID_TOKEN));
        }

        return OAuth2TokenValidatorResult.success();
    }

}
