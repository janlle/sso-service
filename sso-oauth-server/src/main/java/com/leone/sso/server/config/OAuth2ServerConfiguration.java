package com.leone.sso.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-24
 **/
@Configuration
public class OAuth2ServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 配置token获取合验证时的策略
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * 配置oauth2的 client信息这里的配置会覆盖配置文件中的配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // secret密码配置从 Spring Security 5.0开始必须以 {bcrypt}+加密后的密码 这种格式填写
        clients.inMemory()
                .withClient("testClient")
                .accessTokenValiditySeconds(7200)
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("testClient"))
                // authorizedGrantTypes 有4种，这里只开启 3 种
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("all");
    }

    /**
     * 设置自定义的token存储策略
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(memoryTokenStore());
    }

    /**
     * token 的存储策略
     *
     * @return
     */
    @Bean
    public TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }


}