package com.andy.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-05-07 21:25
 **/
@RestController
@SpringBootApplication
@EnableOAuth2Sso
public class SSOClient {

    public static void main(String[] args) {
        SpringApplication.run(SSOClient.class, args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

}
