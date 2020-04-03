package com.shengda.core.security.handler;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shengda.base.wrapper.WrapMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author takesi
 * @date 2020-03-29
 */
@Component
@AllArgsConstructor
public class OauthLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(OauthLogoutSuccessHandler.class);

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private final ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        String redirectUri = request.getParameter("redirect_uri");
        if (StrUtil.isNotEmpty(redirectUri)) {
            //重定向指定的地址
            redirectStrategy.sendRedirect(request, response, redirectUri);
        } else {
            response.setStatus(HttpStatus.OK.value());
            response.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter writer = response.getWriter();
            String jsonStr = objectMapper.writeValueAsString(WrapMapper.ok("登出成功"));
            writer.write(jsonStr);
            writer.flush();
        }
    }
}
