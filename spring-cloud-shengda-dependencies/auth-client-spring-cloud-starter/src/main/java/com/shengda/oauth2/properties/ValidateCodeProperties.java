package com.shengda.oauth2.properties;

import lombok.Getter;

import java.io.Serializable;

/**
 * 验证码配置
 *
 * @author takesi
 * @date 2020-01-31
 */
@Getter
public class ValidateCodeProperties implements Serializable {

    private static final long serialVersionUID = 3930084572578143002L;

    /**
     * 设置认证通时不需要验证码的clientId
     */
    private String[] ignoreClientCode = {};

    public void setIgnoreClientCode(String[] ignoreClientCode) {
        this.ignoreClientCode = ignoreClientCode;
    }
}
