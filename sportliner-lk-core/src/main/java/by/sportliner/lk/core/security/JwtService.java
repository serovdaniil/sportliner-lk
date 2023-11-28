package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

public interface JwtService extends JwtDecoder {

    String create(UserAccount account, long ttl) throws JwtException;

    @Override
    Jwt decode(String token) throws JwtException;

    String extractUsername(String token) throws JwtException;

}
