package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class RotationDto implements Serializable {

    private static final long serialVersionUID = -462465504229950714L;

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
     * 备注
     */
    private String remark;

}
