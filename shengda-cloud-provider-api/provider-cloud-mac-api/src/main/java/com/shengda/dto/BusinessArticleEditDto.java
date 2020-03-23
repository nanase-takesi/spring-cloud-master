package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessArticleEditDto implements Serializable {

    private static final long serialVersionUID = -8133383011229890719L;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 上传缩略图
     */
    private String imageUrl;

    /**
     * 正文链接
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 文章简介
     */
    private String remark;

}
