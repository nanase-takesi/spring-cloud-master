package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
@TableName(value = "mac_rotation")
@EqualsAndHashCode(callSuper = false)
public class Rotation extends BaseEntity {

    private static final long serialVersionUID = -1691492210875645503L;

    /**
     * 轮播内容
     */
    @TableField(value = "name")
    private String name;

    /**
     * 轮播图
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
    @TableField(value = "create_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long createId;

}
