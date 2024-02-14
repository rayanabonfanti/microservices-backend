package com.microservice.apigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {

    @Value("${my-secret-key}")
    private String mySecretKey;
    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(mySecretKey);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }
}
