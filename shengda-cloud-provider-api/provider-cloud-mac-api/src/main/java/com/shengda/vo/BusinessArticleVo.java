package com.shengda.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessArticleVo implements Serializable {

    private static final long serialVersionUID = 6564430874559596207L;

    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 上传缩略图
     */
    private String imageUrl;

    /**
     * 名片id
     */
    private Long cardId;

    /**
     * 正文链接
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
     * 文章简介
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
