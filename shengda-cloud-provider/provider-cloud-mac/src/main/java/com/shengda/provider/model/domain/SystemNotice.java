package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "mac_system_notice")
public class SystemNotice extends BaseEntity {

    private static final long serialVersionUID = -6955498367065924673L;

    /**
     * 公告内容
     */
    @TableField(value = "name")
    private String name;

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
