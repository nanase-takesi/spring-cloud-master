package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessNoticeDto implements Serializable {

    private static final long serialVersionUID = 1143885233292035705L;

    /**
     * 公告内容
     */
    private String name;

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
     * 备注
     */
    private String remark;

}
