package com.andy.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-09-19
 **/
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.tokenKeyAccess("permitAll()")           //能够获取token的
//                .checkTokenAccess("isAuthenticated()");     //检测是否认证
//    }


//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("client1")
//                .secret("client1")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("all")
//                .and()
//                .withClient("client2")
//                .secret("client2")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("all");
//    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientA")                       //clientId
                .secret("secretA")                           //secret
                .authorizedGrantTypes("authorization_code")  //授权模式
                .scopes("all")                               //范围，只获取用户认证。
                .and()
                .withClient("clientB")
                .secret("secretB")
                .authorizedGrantTypes("authorization_code")
                .scopes("all")
//                .autoApprove(true)
        ;


    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
//    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 保证JWT安全 类似签名
        jwtAccessTokenConverter.setSigningKey("hello");
        return jwtAccessTokenConverter;
    }

}