package com.leone.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author leone
 * @since 2018-05-07
 **/
@EnableOAuth2Sso
@SpringBootApplication
public class Client1Application {
    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class, args);
    }

//    @GetMapping("/product/{id}")
//    public String getProduct(@PathVariable String id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.debug("authentication:{}", authentication);
//        return "product id : " + id;
//    }
//
//    @GetMapping("/order/{id}")
//    public String getOrder(@PathVariable String id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.debug("authentication:{}", authentication);
//        return "order id : " + id;
//    }
//
//    @GetMapping("/user")
//    public Authentication getUser(Authentication authentication) {
//        log.info("auth : {}", authentication);
//        return authentication;
//    }

}
