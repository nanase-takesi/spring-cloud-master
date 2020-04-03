package com.shengda.core.security.filter;

import com.shengda.core.exception.ValidateCodeException;
import com.shengda.oauth2.constants.SecurityConstants;
import com.shengda.oauth2.properties.SecurityProperties;
import com.shengda.oauth2.util.AuthUtils;
import com.shengda.provider.service.ValidateCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2020-03-29
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeFilter.class);

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 返回true代表不执行过滤器，false代表执行
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        //登录提交的时候验证验证码
        if (pathMatcher.match(SecurityConstants.PASSWORD_LOGIN_PRO_URL, request.getRequestURI())) {
            //判断是否有不验证验证码的client
            if (securityProperties.getCode().getIgnoreClientCode().length > 0) {
                try {
                    final String[] clientInfos = AuthUtils.extractClient(request);
                    String clientId = clientInfos[0];
                    for (String client : securityProperties.getCode().getIgnoreClientCode()) {
                        if (client.equals(clientId)) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    logger.error("解析client信息失败", e);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            validateCodeService.validate(request);
        } catch (ValidateCodeException e) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            return;
        }
        chain.doFilter(request, response);
    }

}
