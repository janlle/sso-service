package com.leone.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leone
 * @since 2018-05-07
 **/
@Controller
@SpringBootApplication
public class Client2Application {
    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }

    @GetMapping("/login")
    public String user() {
        return "user";
    }

}
