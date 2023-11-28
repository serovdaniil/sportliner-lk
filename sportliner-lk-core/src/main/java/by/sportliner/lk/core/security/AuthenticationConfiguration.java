package by.sportliner.lk.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalAuthentication
public class AuthenticationConfiguration {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userCredentialsAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider userCredentialsAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService());
        provider.setUserDetailsPasswordService(userDetailsPasswordService());

        // account status checks should be performed after credentials check for better security
        provider.setPreAuthenticationChecks((userDetails) -> {
        });
        provider.setPostAuthenticationChecks(new AccountStatusUserDetailsChecker());

        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public UserDetailsPasswordService userDetailsPasswordService() {
        return new UserDetailsPasswordServiceImpl();
    }

}
