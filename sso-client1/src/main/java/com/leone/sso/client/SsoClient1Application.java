package com.leone.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author leone
 * @since 2018-05-07
 **/
@EnableOAuth2Sso
@SpringBootApplication
public class SsoClient1Application {
    public static void main(String[] args) {
        SpringApplication.run(SsoClient1Application.class, args);
    }
}
