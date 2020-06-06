package com.leone.sso.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-24
 **/
@Slf4j
@Controller
public class LoginController {

    //@GetMapping("/authentication/require")
    //public ModelAndView login() {
    //    return new ModelAndView("login");
    //}

    @ResponseBody
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        System.out.println("auth: " + authentication);
        return authentication;
    }

}