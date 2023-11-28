package by.sportliner.lk.core.security;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Objects;



public class JwtMeta {

    static final String CLAIM_SCOPE = "scope";
    static final String CLAIM_SUBJECT_NAME = "sub_name";
    static final String CLAIM_TARGET_SUBJECT = "t_sub";
    static final String CLAIM_TARGET_SUBJECT_NAME = "t_sub_name";

    private final Jwt jwt;

    public JwtMeta(Jwt jwt) {
        Objects.requireNonNull(jwt, "jwt");
        this.jwt = jwt;
    }

    public String getSubject() {
        return jwt.getSubject();
    }

    public String getSubjectName() {
        return jwt.getClaim(CLAIM_SUBJECT_NAME);
    }

    public String getTargetSubject() {
        return jwt.getClaim(CLAIM_TARGET_SUBJECT);
    }

    public String getTargetSubjectName() {
        return jwt.getClaim(CLAIM_TARGET_SUBJECT_NAME);
    }
}
