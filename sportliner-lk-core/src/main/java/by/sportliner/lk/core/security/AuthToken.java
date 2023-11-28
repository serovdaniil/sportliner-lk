package by.sportliner.lk.core.security;

public class AuthToken {

    private final String token;

    private final String type;

    private final int expiresIn;

    public AuthToken(String token, String type, int expiresIn) {
        this.token = token;
        this.type = type;
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
