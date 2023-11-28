package by.sportliner.lk.core.security;

/**
 * Authentication response.
 */
public class AuthenticationResponse {

    /**
     * Status.
     */
    private Status status;

    /**
     * Token, in case of success.
     */
    private AuthToken token;

    /**
     * Refresh token, in case of success.
     */
    private AuthToken refreshToken;

    /**
     * Info, in case of success.
     */
    private AuthInfo info;

    /**
     * Session timeout (seconds).
     */
    private int sessionTimeout;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AuthToken getToken() {
        return token;
    }

    public void setToken(AuthToken token) {
        this.token = token;
    }

    public AuthToken getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(AuthToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    public AuthInfo getInfo() {
        return info;
    }

    public void setInfo(AuthInfo info) {
        this.info = info;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public enum Status {

        SUCCESS,

        MUST_CHANGE_PASSWORD

    }

}
