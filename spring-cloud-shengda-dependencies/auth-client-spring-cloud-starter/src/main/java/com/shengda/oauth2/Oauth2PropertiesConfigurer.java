package com.shengda.oauth2;

import com.shengda.oauth2.properties.SecurityProperties;
import com.shengda.oauth2.store.AuthDbTokenStore;
import com.shengda.oauth2.store.AuthJwtTokenStore;
import com.shengda.oauth2.store.AuthRedisTokenStore;
import com.shengda.oauth2.store.ResJwtTokenStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author takesi
 * @date 2020-01-31
 */
@EnableConfigurationProperties(SecurityProperties.class)
public class Oauth2PropertiesConfigurer implements CommandLineRunner {

    /**
     * 装配BCryptPasswordEncoder用户密码的匹配
     *
     * @return PasswordEncoder
     */
    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @ConditionalOnProperty(prefix = "spring.oauth2.token.store", name = "type", havingValue = "db")
    @Import(AuthDbTokenStore.class)
    public static class JdbcTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "spring.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
    @Import(AuthRedisTokenStore.class)
    public static class RedisTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "spring.oauth2.token.store", name = "type", havingValue = "authJwt")
    @Import(AuthJwtTokenStore.class)
    public static class AuthJwtTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "spring.oauth2.token.store", name = "type", havingValue = "resJwt")
    @Import(ResJwtTokenStore.class)
    public static class ResJwtTokenConfig {
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
