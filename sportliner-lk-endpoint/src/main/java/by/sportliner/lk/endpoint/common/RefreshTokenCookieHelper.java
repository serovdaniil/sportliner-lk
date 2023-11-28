package by.sportliner.lk.endpoint.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

/**
 * Helper class for processing refresh-token cookie.
 */
public class RefreshTokenCookieHelper {

    private static final String REFRESH_TOKEN_COOKIE_NAME = "rt";

    public static RefreshTokenCookieHelper get(String authApiPrefix) {
        return get(authApiPrefix, (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes());
    }

    private static RefreshTokenCookieHelper get(String authApiPathPrefix, ServletRequestAttributes servletRequestAttributes) {
        return new RefreshTokenCookieHelper(servletRequestAttributes, authApiPathPrefix);
    }

    private final ServletRequestAttributes servletRequestAttributes;

    private final String path;

    public RefreshTokenCookieHelper(ServletRequestAttributes servletRequestAttributes, String path) {
        this.servletRequestAttributes = servletRequestAttributes;
        this.path = path;
    }

    public String getToken() {
        return getCookie(REFRESH_TOKEN_COOKIE_NAME);
    }

    public void setToken(String value) {
        addCookie(REFRESH_TOKEN_COOKIE_NAME, path, value, -1);
    }

    public void clearToken() {
        addCookie(REFRESH_TOKEN_COOKIE_NAME, path, "", 0);
    }

    private void addCookie(String name, String path, String value, int maxAge) {
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        Cookie cookie = new Cookie(name, value);
        cookie.setPath(request.getServletContext().getContextPath() + path);
        cookie.setHttpOnly(true);
        cookie.setSecure(request.isSecure());
        cookie.setMaxAge(maxAge);

        response.addCookie(cookie);
    }

    private String getCookie(String name) {
        HttpServletRequest request = servletRequestAttributes.getRequest();

        Cookie cookie = WebUtils.getCookie(request, name);
        return cookie != null ? cookie.getValue() : null;
    }

}
