package com.luv2code.ssecurity.SSecurityApp1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // This annotation tells Spring that this class contains configuration beans
@EnableWebSecurity // This annotation enables Spring Security for the application, allowing the class to customize security behaviors
public class SecurityConfig {

    @Bean
    // This method configures security settings for the application
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // This section configures how requests are authorized, The code inside ensures that any request to the application must be authenticated
        http.authorizeHttpRequests((requests) -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
        });
        // This disables the use of cookies and sessions in the application, meaning no sessions are stored on the server
        // This is typically used for APIs with stateless authentication methods like JWT (JSON Web Token)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // It uses the default login form provided by Spring Security for user authentication
        http.formLogin(Customizer.withDefaults());
        // Enables basic HTTP authentication. This sends the username and password with every request using the standard "Authorization" HTTP header
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build(); // Builds and returns the SecurityFilterChain object, which defines the final security configuration
    }

}
