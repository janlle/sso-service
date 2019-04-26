package com.leone.sso.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-24
 **/
@RestController
public class BaseController {

    @RequestMapping(value = "/api/hello")
    public String hello(String code) {
        return "hello " + code;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}