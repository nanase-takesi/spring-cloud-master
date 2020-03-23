package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class BusinessCardDto implements Serializable {

    private static final long serialVersionUID = 626254453693574536L;

    /**
     * 名片名称
     */
    private String name;

    /**
     * 绑定用户id
     */
    private Long userId;

    /**
     * 绑定用户名称
     */
    private String userName;

    /**
     * 上传封面图
     */
    private String imageUrl;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 有效起始时间
     */
    private Date expireStartTime;

    /**
     * 有效结束时间
     */
    private Date expireEndTime;

    /**
     * 备注
     */
    private String remark;

}
