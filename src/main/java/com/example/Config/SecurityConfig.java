package com.example.Config;

import com.example.Service.AuthorizationServiceImplement;
import com.example.model.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(AuthorizationServiceImplement authorizationServiceImplement) {
        return username -> {
            Authorization authorization = authorizationServiceImplement.findByUsername(username);
            if (authorization != null) return authorization;
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }
}
