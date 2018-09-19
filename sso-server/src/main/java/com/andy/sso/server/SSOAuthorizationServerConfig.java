package com.andy.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Leone
 * @createBy: 2018-05-07 21:10
 **/
@Configuration
public class SSOAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withClient("clienta")
        .secret("secreta")
        .authorizedGrantTypes("authorization_code", "refresh_token")
        .scopes("all")
        .and()
        .withClient("clientb")
        .secret("secretb")
        .authorizedGrantTypes("authorization_code", "refresh_token")
        .scopes("all");

//        clients.inMemory()
//                .withClient("clienta")
//                .secret("secreta")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("all","read","write")
//                .autoApprove(true)
//                .and()
//                .withClient("clientb")
//                .secret("secretb")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("all","read","write")
//                .autoApprove(true);
    }

    /**
     * 配置jwttokenStore
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
    }

    /**
     * springSecurity 授权表达式，访问merryyou tokenkey时需要经过认证
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * JWTtokenStore
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 生成JTW token
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("andy");
        return converter;
    }
}
