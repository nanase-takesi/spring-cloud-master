package com.shengda.oauth2.properties;

import lombok.Getter;

import java.io.Serializable;

/**
 * 认证配置
 *
 * @author takesi
 * @date 2020-01-31
 */
@Getter
public class AuthProperties implements Serializable {

    private static final long serialVersionUID = 1215187949392936572L;

    /**
     * 配置要认证的url（默认不需要配置）
     * <p>
     * 优先级大于忽略认证配置`zlt.security.ignore.httpUrls`
     * 意思是如果同一个url同时配置了`忽略认证`和`需要认证`，则该url还是会被认证
     */
    private String[] httpUrls = {};

    /**
     * token自动续签配置（目前只有redis实现）
     */
    private RenewProperties renew = new RenewProperties();

    /**
     * url权限配置
     */
    private UrlPermissionProperties urlPermission = new UrlPermissionProperties();

    public void setHttpUrls(String[] httpUrls) {
        this.httpUrls = httpUrls;
    }

    public void setRenew(RenewProperties renew) {
        this.renew = renew;
    }

    public void setUrlPermission(UrlPermissionProperties urlPermission) {
        this.urlPermission = urlPermission;
    }
}
