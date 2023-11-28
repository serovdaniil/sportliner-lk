package by.sportliner.lk.core.security;

import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import by.sportliner.lk.core.repository.UserAccountRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.factories.DefaultJWSSignerFactory;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.proc.SingleKeyJWSKeySelector;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService, InitializingBean {

    private static final JWSAlgorithm JWS_ALGORITHM = JWSAlgorithm.HS512;

    private static final String CLAIM_SCOPE = "scope";

    private static final String CLAIM_SUBJECT_NAME = "sub_name";

    @Value("${jwt.secret.password}")
    private String secretPassword;

    @Value("${jwt.secret.salt}")
    private String secretSalt;

    private SecretKey secretKey;

    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public void afterPropertiesSet() {
        secretKey = generateKey(secretPassword, secretSalt);
    }

    @Override
    public String create(UserAccount account, long ttl) throws JwtException {
        Instant now = Instant.now();

        JWSHeader header = new JWSHeader.Builder(JWS_ALGORITHM)
            .type(JOSEObjectType.JWT)
            .build();

        UserRole role = account.getRole();

        Set<String> scopes = new HashSet<>();
        scopes.add("ROLE_" + role.name());
        scopes.addAll(role.getAuthorities().stream()
            .map(Enum::name)
            .collect(Collectors.toList())
        );

        JWTClaimsSet claims = new JWTClaimsSet.Builder()
            .subject(account.getId())
            .claim(JwtMeta.CLAIM_SUBJECT_NAME, account.getUsername())
            .issueTime(Date.from(now))
            .expirationTime(Date.from(now.plusSeconds(ttl)))
            .claim(JwtMeta.CLAIM_SCOPE, String.join(" ", scopes))
            .build();

        SignedJWT signed = sign(header, claims);

        return signed.serialize();
    }

    @Override
    public Jwt decode(String token) throws JwtException {
        return decodeAndValidate(token, List.of(
            new JwtTimestampValidator(),
            new JwtRevokeValidator(userAccountRepository::findById)
        ));
    }

    @Override
    public String extractUsername(String token) throws JwtException {
        // skipping timestamp/revoke checks here
        Jwt jwt = decodeAndValidate(token, List.of());
        return jwt.getClaim(CLAIM_SUBJECT_NAME);
    }

    private Jwt decodeAndValidate(String token, List<OAuth2TokenValidator<Jwt>> validators) {
        DefaultJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
        jwtProcessor.setJWSKeySelector(new SingleKeyJWSKeySelector<>(JWS_ALGORITHM, secretKey));

        NimbusJwtDecoder decoder = new NimbusJwtDecoder(jwtProcessor);
        decoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(validators));

        return decoder.decode(token);
    }

    private SignedJWT sign(JWSHeader header, JWTClaimsSet claims) throws JwtException {
        try {
            JWSSigner signer = new DefaultJWSSignerFactory()
                .createJWSSigner(new OctetSequenceKey.Builder(secretKey).build());

            SignedJWT result = new SignedJWT(header, claims);
            result.sign(signer);
            return result;
        }
        catch (JOSEException e) {
            throw new JwtException("Failed to sign JWT token", e);
        }
    }

    private static SecretKey generateKey(String secret, String salt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(new PBEKeySpec(secret.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 1024, 512));
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalStateException(e);
        }
    }

}
