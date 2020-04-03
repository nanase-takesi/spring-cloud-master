package com.shengda.provider.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.shengda.core.context.TenantContextHolder;
import com.shengda.core.support.BaseController;
import com.shengda.oauth2.constants.SecurityConstants;
import com.shengda.oauth2.token.OpenIdAuthenticationToken;
import com.shengda.oauth2.util.AuthUtils;
import com.shengda.oauth2.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2020-04-02
 */
@RestController
@AllArgsConstructor
public class Oauth2Controller extends BaseController {

    private final ObjectMapper objectMapper;

    private final PasswordEncoder passwordEncoder;

    private final ClientDetailsService clientDetailsService;

    private final AuthenticationManager authenticationManager;

    @Resource
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @PostMapping(value = SecurityConstants.PASSWORD_LOGIN_PRO_URL)
    public void getUserTokenInfo(String username, String password, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        writerToken(request, response, token, "用户名或密码错误");
    }

    @PostMapping(SecurityConstants.OPENID_TOKEN_URL)
    public void getTokenByOpenId(String openId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OpenIdAuthenticationToken token = new OpenIdAuthenticationToken(openId);
        writerToken(request, response, token, "openId错误");
    }

    private void writerToken(HttpServletRequest request, HttpServletResponse response, AbstractAuthenticationToken token
            , String badCredentialMsg) throws IOException {
        try {
            final String[] clientInfos = AuthUtils.extractClient(request);
            String clientId = clientInfos[0];
            String clientSecret = clientInfos[1];
            ClientDetails clientDetails = getClient(clientId, clientSecret);
            //保存租户id
            TenantContextHolder.setTenant(clientId);
            TokenRequest tokenRequest = new TokenRequest(Maps.newHashMap(), clientId, clientDetails.getScope(), "customer");
            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
            OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
            oAuth2Authentication.setAuthenticated(true);
            ResponseUtil.responseSucceed(objectMapper, response, oAuth2AccessToken);
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {
            exceptionHandler(response, badCredentialMsg);
        } catch (Exception e) {
            exceptionHandler(response, e);
        }
    }

    private void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        logger.error("exceptionHandler-error:", e);
        exceptionHandler(response, e.getMessage());
    }

    private void exceptionHandler(HttpServletResponse response, String msg) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ResponseUtil.responseFailed(objectMapper, response, msg);
    }

    private ClientDetails getClient(String clientId, String clientSecret) {
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId对应的信息不存在");
        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException("clientSecret不匹配");
        }
        return clientDetails;
    }

}
