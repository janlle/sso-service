package com.leone.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author leone
 * @since 2018-05-07
 **/
@SpringBootApplication
@EnableAuthorizationServer
public class SsoOAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoOAuthApplication.class, args);
    }
}
