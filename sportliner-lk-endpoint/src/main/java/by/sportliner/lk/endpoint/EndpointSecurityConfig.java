package by.sportliner.lk.endpoint;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class EndpointSecurityConfig {

    @Bean
    public SecurityFilterChain actuaturSecurityFilterChain(HttpSecurity http) throws Exception {
        // SecurityFilterChain for actuator endpoints (/management/*)
        http.securityMatcher(EndpointRequest.toAnyEndpoint());
        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public SecurityFilterChain applicationSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.oauth2ResourceServer().jwt();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .authorizeHttpRequests(SportlinerLkApiMeta::configureAuthorization);

        return http.build();
    }

}
