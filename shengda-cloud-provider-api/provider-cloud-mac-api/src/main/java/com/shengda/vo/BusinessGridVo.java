package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessGridVo implements Serializable {

    private static final long serialVersionUID = 3248068263267818716L;

    private Long id;

    /**
     * 图标名称
     */
    private String name;

    /**
     * 上传图标
     */
    private String imageUrl;

    /**
     * 跳转链接
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
