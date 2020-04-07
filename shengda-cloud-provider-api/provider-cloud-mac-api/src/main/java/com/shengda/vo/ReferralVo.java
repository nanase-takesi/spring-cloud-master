package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class ReferralVo implements Serializable {

    private static final long serialVersionUID = 784229306782159124L;

    private Long id;

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

    private Date createTime;

    private Date updateTime;

}
