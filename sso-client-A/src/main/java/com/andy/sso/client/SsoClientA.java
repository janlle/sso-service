package com.andy.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

import java.nio.charset.StandardCharsets;

/**
 * @author Leone
 * @since 2018-05-07
 **/
@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class SsoClientA {

//    @Autowired
//    private OAuth2RestTemplate oAuth2RestTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SsoClientA.class, args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

//    @Bean
//    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails details){
//        return new OAuth2RestTemplate(details,oAuth2ClientContext);
//    }


}
