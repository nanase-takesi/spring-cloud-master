package com.shengda.oauth2.properties;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * url权限配置
 *
 * @author takesi
 * @date 2020-01-31
 */
@Getter
public class UrlPermissionProperties implements Serializable {

    private static final long serialVersionUID = -2387650753197915441L;

    /**
     * 是否开启url级别权限
     */
    private Boolean enable = false;

    /**
     * 白名单，配置需要url权限认证的应用id（与黑名单互斥，只能配置其中一个），不配置默认所有应用都生效
     * 配置enable为true时才生效
     */
    private List<String> includeClientIds = new ArrayList<>();

    /**
     * 黑名单，配置不需要url权限认证的应用id（与白名单互斥，只能配置其中一个）
     * 配置enable为true时才生效
     */
    private List<String> exclusiveClientIds = new ArrayList<>();

    /**
     * 配置只进行登录认证，不进行url权限认证的api
     * 所有已登录的人都能访问的api
     */
    private String[] ignoreUrls = {};

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void setIncludeClientIds(List<String> includeClientIds) {
        this.includeClientIds = includeClientIds;
    }

    public void setExclusiveClientIds(List<String> exclusiveClientIds) {
        this.exclusiveClientIds = exclusiveClientIds;
    }

    public void setIgnoreUrls(String[] ignoreUrls) {
        this.ignoreUrls = ignoreUrls;
    }
}
