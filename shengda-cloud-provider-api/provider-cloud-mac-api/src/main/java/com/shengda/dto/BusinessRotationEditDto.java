package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class BusinessRotationEditDto implements Serializable {

    private static final long serialVersionUID = 8997251500577501076L;

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
