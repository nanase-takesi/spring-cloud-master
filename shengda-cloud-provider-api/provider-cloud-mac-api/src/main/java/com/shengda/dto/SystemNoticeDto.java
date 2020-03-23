package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Data
public class SystemNoticeDto implements Serializable {

    private static final long serialVersionUID = -2977841240223507524L;

    /**
     * 公告内容
     */
    private String name;

    /**
     * 跳转连接
     */
    private String url;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

}
