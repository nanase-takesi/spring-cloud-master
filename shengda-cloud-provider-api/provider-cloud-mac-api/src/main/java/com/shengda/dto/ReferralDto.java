package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class ReferralDto implements Serializable {

    private static final long serialVersionUID = -4902828698052859708L;

    /**
     * 推荐内容名称
     */
    private String name;

    /**
     * 封面图
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
