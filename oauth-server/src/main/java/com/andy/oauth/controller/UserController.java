package com.andy.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-09-19
 **/
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/auth")
    public void auth(String code) {
        System.out.println(code);
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

}
