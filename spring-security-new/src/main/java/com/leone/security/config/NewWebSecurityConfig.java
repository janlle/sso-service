package com.leone.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * <p>
 *
 * @author leone
 * @since 2023-05-01
 **/
@Configuration
public class NewWebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .antMatcher("/**")
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .build();
    }


}
