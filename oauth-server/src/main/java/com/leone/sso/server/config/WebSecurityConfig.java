package com.leone.sso.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Order(1)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * oauth配置中需要用到
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(bCryptPasswordEncoder().encode("user"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin()
        //        .loginPage("/authentication/require")
        //        .loginProcessingUrl("/authentication/form")
        //        .and()
        //        .authorizeRequests()
        //        .antMatchers("/authentication/require", "/authentication/form")
        //        .permitAll()
        //        .anyRequest().authenticated()
        //        .and()
        //        .csrf()
        //        .disable();
        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

