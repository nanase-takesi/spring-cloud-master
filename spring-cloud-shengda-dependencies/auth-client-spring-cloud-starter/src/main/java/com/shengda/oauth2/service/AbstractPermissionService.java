package com.shengda.oauth2.service;

import com.shengda.oauth2.properties.SecurityProperties;
import lombok.AllArgsConstructor;
import org.springframework.util.AntPathMatcher;

/**
 * 请求权限判断service
 *
 * @author takesi
 * @date 2020-01-31
 */
@AllArgsConstructor
public abstract class AbstractPermissionService {

    private final SecurityProperties securityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

}
