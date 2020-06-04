package com.leone.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-24
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}