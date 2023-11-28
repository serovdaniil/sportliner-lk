package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.UserAuthority;
import by.sportliner.lk.core.security.AuthToken;
import by.sportliner.lk.core.security.AuthenticationRequest;
import by.sportliner.lk.core.security.AuthenticationResponse;
import by.sportliner.lk.core.security.AuthenticationService;
import by.sportliner.lk.endpoint.SportlinerLkApiMeta;
import by.sportliner.lk.endpoint.api.*;
import by.sportliner.lk.endpoint.common.RefreshTokenCookieHelper;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AuthApiController implements AuthApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthApiController.class);

    @Resource
    private AuthenticationService authenticationService;

    @Override
    public ResponseEntity<AuthResponseDto> login(AuthCredentialsDto authCredentialsDto) {
        AuthenticationRequest request = new AuthenticationRequest(
            authCredentialsDto.getUsername(),
            authCredentialsDto.getPassword(),
            Set.of(UserAuthority.ACCESS_APPLICATION)
        );

        AuthenticationResponse response = authenticationService.authenticate(request);

        putRefreshToken(response);

        return ResponseEntity.ok(convert(response));
    }

    @Override
    public ResponseEntity<Void> logout(Boolean automatic) {
        refreshTokenCookieHelper().clearToken();

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<AuthResponseDto> refresh() {
        String value = refreshTokenCookieHelper().getToken();

        if (value == null) {
            throw new BadCredentialsException("No refresh token found!");
        }

        AuthenticationResponse response = authenticationService.refresh(value);

        putRefreshToken(response);

        return ResponseEntity.ok(convert(response));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<BaseErrorDto> on(BadCredentialsException exception, WebRequest request) {
        LOGGER.warn("Authentication error: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(new AuthenticationErrorDto()
                .reason(AuthenticationErrorDto.ReasonEnum.INVALID_CREDENTIALS)
                .type(BaseErrorTypeDto.AUTHENTICATION)
                .message(exception.getMessage())
            );
    }

    private void putRefreshToken(AuthenticationResponse response) {
        AuthToken refreshToken = response.getRefreshToken();
        if (refreshToken != null) {
            refreshTokenCookieHelper().setToken(refreshToken.getToken());
        }
    }

    private RefreshTokenCookieHelper refreshTokenCookieHelper() {
        return RefreshTokenCookieHelper.get(SportlinerLkApiMeta.AUTH_API_PATH_PREFIX);
    }

    private AuthResponseDto convert(AuthenticationResponse input) {
        AuthResponseDto result = new AuthResponseDto();

        result.setStatus(AuthResponseDto.StatusEnum.valueOf(input.getStatus().name()));
        result.setToken(Optional.ofNullable(input.getToken())
            .map(it -> new AuthTokenDto()
                .accessToken(it.getToken())
                .tokenType(it.getType())
                .expiresIn(it.getExpiresIn())
            )
            .orElse(null)
        );
        result.setInfo(Optional.ofNullable(input.getInfo())
            .map(it -> new AuthInfoDto()
                .id(it.getId())
                .username(it.getUsername())
                .firstName(it.getFirstName())
                .lastName(it.getLastName())
                .authorities(it.getAuthorities()
                    .stream()
                    .map(UserAuthority::name)
                    .collect(Collectors.toList())
                )
            )
            .orElse(null)
        );

        result.sessionTimeout(input.getSessionTimeout());

        return result;
    }

}
