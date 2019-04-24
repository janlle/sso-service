package com.leone.resource.config;


import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * <p>
 *
 * @author leone
 * @since 2018-10-31
 **/
//@Configuration
//@EnableResourceServer
//public class SsoResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/**")
//                .access("#oauth2.hasScope('read')")
//                .antMatchers(HttpMethod.POST, "/api/**")
//                .access("#oauth2.hasScope('write')");
//    }
//
//    @Bean
//    @Profile("!cloud")
//    public RequestDumperFilter requestDumperFilter() {
//        return new RequestDumperFilter();
//    }
//
//}