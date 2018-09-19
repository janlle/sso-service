package com.andy.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

}
