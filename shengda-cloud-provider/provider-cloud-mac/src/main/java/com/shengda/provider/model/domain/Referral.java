package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
@TableName(value = "mac_referral")
@EqualsAndHashCode(callSuper = false)
public class Referral extends BaseEntity {

    private static final long serialVersionUID = -6140808889996118937L;

    /**
     * 推荐内容名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 封面图
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 跳转连接
     */
    @TableField(value = "url")
    private String url;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Short state;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建人id
     */
    @TableField(value = "create_id")
    private Long createId;

}
