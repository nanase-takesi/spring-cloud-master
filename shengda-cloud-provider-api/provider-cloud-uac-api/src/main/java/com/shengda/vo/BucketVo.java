package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Data
public class BucketVo implements Serializable {

    private static final long serialVersionUID = 5666929032056758344L;

    private Long id;

    /**
     * 数据存储桶名称
     */
    private String name;

    /**
     * 存储类型
     */
    private Short type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
