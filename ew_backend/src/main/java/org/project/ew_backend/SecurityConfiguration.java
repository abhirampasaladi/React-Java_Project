package org.project.ew_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(customizer->customizer.disable())
                .authorizeHttpRequests(request->request.requestMatchers("/login").permitAll().anyRequest().authenticated())
                .formLogin(customizer->customizer.loginPage("/login"))
                .build();
    }
}
