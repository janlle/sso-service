package com.andy.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextListener;

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

    //自定义一个RequestContextListener
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
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
