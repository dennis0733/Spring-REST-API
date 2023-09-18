package com.productservice.restapi.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecureCheckPassword {

@Bean
public InMemoryUserDetailsManager userDetailsManager(){
    UserDetails user = User
            .withUsername("user") // Replace with your username
            .password("{noop}user123") // Replace with your password
            .roles("USER")
            .build();


    return new InMemoryUserDetailsManager(user);
}
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

        }

