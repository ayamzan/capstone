package com.example.corebankingapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/logout", "/styles.css", "/favicon.svg").permitAll()
<<<<<<< HEAD
                        .requestMatchers("/", "/new", "/save", "/newrole", "/saverole", "/edit/*", "/delete/*",
                                "/accounts/*", "/customers/*", "/transaction/*")
                        .authenticated()
                // Add specific authorization for Account endpoints with multiple roles
                // .requestMatchers("/accounts/*").hasAnyAuthority("GUEST", "ADMIN", "MANAGER",
                // "TELLER")
                // .requestMatchers("/customers/*").hasAnyAuthority("ADMIN", "MANAGER",
                // "TELLER")
                )
=======
                        .requestMatchers("/", "/new", "/save", "/newrole", "/saverole", "/edit/*", "/delete/*")
                        .authenticated())
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
                .formLogin(fl -> fl
                        .successForwardUrl("/")
                        .permitAll())
                .logout(lo -> lo
                        .logoutSuccessUrl("/login"));
        return http.build();
    }

}
