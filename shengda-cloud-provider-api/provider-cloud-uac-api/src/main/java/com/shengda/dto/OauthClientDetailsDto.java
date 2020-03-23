package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-02
 */
@Data
public class OauthClientDetailsDto implements Serializable {

    private static final long serialVersionUID = -3130901560231573200L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 应用标识
     */

    private String clientId;

    /**
     * 资源限定串(逗号分割)
     */
    private String resourceIds;

    /**
     * 应用密钥(bcyt) 加密
     */
    private String clientSecret;

    /**
     * 应用密钥(明文)
     */
    private String clientSecretStr;

    /**
     * 范围
     */
    private String scope;

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    private String webServerRedirectUri;

    /**
     * 权限
     */
    private String authorities;

    /**
     * access_token有效期
     */
    private Integer accessTokenValidity;

    /**
     * refresh_token有效期
     */
    private Integer refreshTokenValidity;

    /**
     * {}
     */
    private String additionalInformation;

    /**
     * 是否自动授权 是-true
     */
    private String autoapprove;

    private Date createTime;

    private Date updateTime;

    /**
     * 应用名称
     */
    private String clientName;

}
