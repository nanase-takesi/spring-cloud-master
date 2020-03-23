package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessVideoEditDto implements Serializable {

    private static final long serialVersionUID = 1412015438870083759L;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频封面图
     */
    private String imageUrl;

    /**
     * 视频文件
     */
    private String fileUrl;

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
