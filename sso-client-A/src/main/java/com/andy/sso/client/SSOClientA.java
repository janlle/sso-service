package com.andy.sso.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leone
 * @createBy: 2018-05-07 21:25
 **/
@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class SSOClientA {

//    @Autowired
//    private OAuth2RestTemplate oAuth2RestTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SSOClientA.class, args);
    }

//    @GetMapping("/user")
//    public Authentication user(Authentication user) {
//        return user;
//    }

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        return restTemplate;
//    }

//    @Bean
//    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails details){
//        return new OAuth2RestTemplate(details,oAuth2ClientContext);
//    }

}
