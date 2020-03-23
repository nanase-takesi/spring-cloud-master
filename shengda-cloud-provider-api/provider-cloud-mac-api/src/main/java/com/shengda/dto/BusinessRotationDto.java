package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class BusinessRotationDto implements Serializable {

    private static final long serialVersionUID = -2324430264589451923L;

    /**
     * 轮播内容
     */
    private String name;

    /**
     * 轮播图
     */
    private String imageUrl;

    /**
     * 跳转连接
     */
    private String url;

    /**
     * 名片id
     */
    private Long cardId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Short state;

    /**
     * 备注
     */
    private String remark;

}
