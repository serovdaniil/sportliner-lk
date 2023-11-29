package by.sportliner.lk.endpoint;


import by.sportliner.lk.core.model.UserAuthority;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class SportlinerLkApiMeta {

    public static final String API_PATH_PREFIX = "/sportliner-lk-api";
    public static final String AUTH_API_PATH_PREFIX = API_PATH_PREFIX + "/auth";

    public static void configureAuthorization(
        AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {

        registry

            .requestMatchers(
                apiPath("/auth/login"),
                apiPath("/auth/logout"),
                apiPath("/auth/refresh"),
                apiPath("/version")
            ).permitAll()

            .requestMatchers(
                apiPath("/users")
            ).hasAuthority(scope(UserAuthority.ADMINISTRATIVE));
    }

    private static String apiPath(String path) {
        return API_PATH_PREFIX + path;
    }

    private static String scope(UserAuthority authority) {
        return "SCOPE_" + authority.name();
    }

}
