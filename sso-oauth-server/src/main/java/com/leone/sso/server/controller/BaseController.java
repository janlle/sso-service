package com.leone.sso.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-24
 **/
@RestController
public class BaseController {

    @GetMapping("/redirect")
    public String redirect(String code) {
        return code;
    }

}