package com.shengda.core.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.security.adapter.ValidateCodeSecurityConfigurerAdapter;
import com.shengda.oauth2.constants.SecurityConstants;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidScopeException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.RedirectMismatchException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-28
 */
@Configuration
@AllArgsConstructor
public class AacWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AacWebSecurityConfigurerAdapter.class);

    private final ObjectMapper objectMapper;

    @Autowired(required = false)
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private LogoutHandler oauthLogoutHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private ValidateCodeSecurityConfigurerAdapter validateCodeSecurityConfigurerAdapter;

    /**
     * 这一步的配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
     *
     * @return 认证管理对象
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage(SecurityConstants.LOGIN_PAGE)
                .loginProcessingUrl(SecurityConstants.OAUTH_LOGIN_PRO_URL)
                .successHandler(loginSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl(SecurityConstants.LOGOUT_URL)
                .logoutSuccessHandler(logoutSuccessHandler)
                .addLogoutHandler(oauthLogoutHandler)
                .clearAuthentication(true)
                .and()
                .apply(validateCodeSecurityConfigurerAdapter)
                .and()
                .csrf().disable()
                // 解决不允许显示在iframe的问题
                .headers().frameOptions().disable().cacheControl();

        // 基于密码 等模式可以无session,不支持授权码模式
        if (authenticationEntryPoint != null) {
            http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        } else {
            // 授权码模式单独处理，需要session的支持，此模式可以支持所有oauth2的认证
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        }
    }

    /**
     * 全局用户信息
     */
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 登陆失败，返回401
     *
     * @return AuthenticationFailureHandler
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, e) -> {
            logger.error(e.getMessage(), e);
            String message;
            if (e instanceof BadCredentialsException) {
                message = "密码错误";
            } else {
                message = e.getMessage();
            }
            HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;
            response.setStatus(unauthorized.value());
            Wrapper<String> wrapper = WrapMapper.wrap(unauthorized.value(), message);
            response.getWriter().write(objectMapper.writeValueAsString(wrapper));
        };
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            public static final String BAD_MSG = "坏的凭证";

            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                OAuth2Exception oAuth2Exception;
                if (e.getMessage() != null && e.getMessage().equals(BAD_MSG)) {
                    oAuth2Exception = new InvalidGrantException("用户名或密码错误", e);
                } else if (e instanceof InternalAuthenticationServiceException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else if (e instanceof RedirectMismatchException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else if (e instanceof InvalidScopeException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else {
                    oAuth2Exception = new UnsupportedResponseTypeException("服务内部错误", e);
                }
                ResponseEntity<OAuth2Exception> response = super.translate(oAuth2Exception);
                ResponseEntity.status(oAuth2Exception.getHttpErrorCode());
                Objects.requireNonNull(response.getBody()).addAdditionalInformation("code", oAuth2Exception.getHttpErrorCode() + "");
                response.getBody().addAdditionalInformation("message", oAuth2Exception.getMessage());

                return response;
            }
        };
    }

    /**
     * 登陆成功
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

}
