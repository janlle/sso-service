package com.andy.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Leone
 * @since 2018-05-07 21:09
 **/
@SpringBootApplication
@EnableAuthorizationServer
public class SSOServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SSOServerApp.class, args);
    }
}
