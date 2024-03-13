package com.spendwise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Correctly define the BCryptPasswordEncoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // If you're using Postman, disabling CSRF might be necessary for testing.
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/auth/**").permitAll() // Allow all requests to your auth endpoints
                .anyRequest().authenticated()
            )
            .formLogin().disable() // Disable form login
            .logout().disable(); // Disable automatic logout

        // Optional: Configure session management
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    // Updated userDetailsService method
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user =
                org.springframework.security.core.userdetails.User.builder()
                .username("email")
                .password(passwordEncoder.encode("password"))
                .roles("USER") // Specify roles here
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
