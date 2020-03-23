package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-01-08
 */
@Data
public class MemberVo implements Serializable {

    private static final long serialVersionUID = -292348177867412855L;

    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 引荐人
     */
    private Long referrerId;

    /**
     * 卡片id
     */
    private Long cardId;

    /**
     * 状态
     */
    private Short state;

}
