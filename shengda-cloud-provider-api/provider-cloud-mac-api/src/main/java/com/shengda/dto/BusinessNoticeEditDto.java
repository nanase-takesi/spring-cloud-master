package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessNoticeEditDto implements Serializable {

    private static final long serialVersionUID = 6245829478102590187L;

    /**
     * 公告内容
     */
    private String name;

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
