package com.shengda.oauth2.properties;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 续签配置
 *
 * @author takesi
 * @date 2020-01-31
 */
@Getter
public class RenewProperties implements Serializable {

    private static final long serialVersionUID = -4983020069069539962L;

    /**
     * 是否开启token自动续签（目前只有redis实现）
     */
    private Boolean enable = false;

    /**
     * 白名单，配置需要自动续签的应用id（与黑名单互斥，只能配置其中一个），不配置默认所有应用都生效
     * 配置enable为true时才生效
     */
    private List<String> includeClientIds = new ArrayList<>();

    /**
     * 黑名单，配置不需要自动续签的应用id（与白名单互斥，只能配置其中一个）
     * 配置enable为true时才生效
     */
    private List<String> exclusiveClientIds = new ArrayList<>();

    /**
     * 续签时间比例，当前剩余时间小于小于过期总时长的50%则续签
     */
    private Double timeRatio = 0.5;

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void setIncludeClientIds(List<String> includeClientIds) {
        this.includeClientIds = includeClientIds;
    }

    public void setExclusiveClientIds(List<String> exclusiveClientIds) {
        this.exclusiveClientIds = exclusiveClientIds;
    }

    public void setTimeRatio(Double timeRatio) {
        this.timeRatio = timeRatio;
    }
}
