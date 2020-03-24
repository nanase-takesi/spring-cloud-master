package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-23
 */
@Data
@TableName(value = "uac_department")
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {

    private static final long serialVersionUID = 8872649631566640783L;

    /**
     * 部门名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 部门简称
     */
    @TableField(value = "short_name")
    private String shortName;

    /**
     * 部门负责人id
     */
    @TableField(value = "manager_id")
    private Long managerId;

    /**
     * 部门负级id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Boolean state;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_SHORT_NAME = "short_name";

    public static final String COL_MANAGER_ID = "manager_id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_SORT = "sort";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
