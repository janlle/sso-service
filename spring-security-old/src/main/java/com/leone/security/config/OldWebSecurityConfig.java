package com.leone.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * <p>
 *
 * @author leone
 * @since 2023-05-01
 **/
@Configuration
public class OldWebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 指定密码的加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return Objects.equals(charSequence.toString(), s);
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN", "USER")
                .and()
                .withUser("leone").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启 HttpSecurity 配置
        http.authorizeRequests()
                // admin/** 模式URL必须具备ADMIN角色
                .antMatchers("/admin/**").hasRole("ADMIN")
                // 该模式需要ADMIN或USER角色
                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
                // 需ADMIN和DBA角色
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                // 用户访问其它URL都必须认证后访问（登录后访问）
                .anyRequest().authenticated()
                // 开启表单登录并配置登录接口
                .and().formLogin().loginProcessingUrl("/login").permitAll()
                // 关闭csrf
                .and().csrf().disable();
    }
}