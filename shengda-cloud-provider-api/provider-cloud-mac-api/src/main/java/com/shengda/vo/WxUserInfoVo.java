package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-30
 */
@Data
public class WxUserInfoVo implements Serializable {

    private static final long serialVersionUID = -5356951444519632726L;

    /**
     * id
     */
    private Long id;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 微信头像
     */
    private String avatarUrl;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 城市
     */
    private String city;

    /**
     * 引荐人名称
     */
    private String referrerName;

    /**
     * 卡片id
     */
    private Long cardId;

    /**
     * 状态
     */
    private Short state;

}
