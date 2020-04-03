package com.shengda.core.security.adapter;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * 校验码相关安全配置
 *
 * @author takesi
 * @date 2020-03-29
 */
@Component
public class ValidateCodeSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private Filter validateCodeFilter;

    @Override
    public void configure(HttpSecurity http) {
        http.addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }

}
