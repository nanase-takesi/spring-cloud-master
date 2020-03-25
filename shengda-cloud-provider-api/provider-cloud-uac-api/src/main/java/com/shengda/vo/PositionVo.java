package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Data
public class PositionVo implements Serializable {

    private static final long serialVersionUID = 694176091548839002L;

    private Long id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位描述
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Boolean state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
