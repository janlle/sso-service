package com.andy.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-09-19
 **/
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
//    }
//
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.parentAuthenticationManager(authenticationManager)
////                .inMemoryAuthentication()
////                .withUser("john").password("admin").roles("USER");
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 用自己的登陆逻辑以及加密器
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//}
