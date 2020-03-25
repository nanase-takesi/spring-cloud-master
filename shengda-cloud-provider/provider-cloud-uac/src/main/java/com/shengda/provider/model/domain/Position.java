package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Data
@TableName(value = "uac_position")
@EqualsAndHashCode(callSuper = false)
public class Position extends BaseEntity {

    private static final long serialVersionUID = 5975801723962463786L;

    /**
     * 岗位名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 岗位描述
     */
    @TableField(value = "remark")
    private String remark;

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

    public static final String COL_REMARK = "remark";

    public static final String COL_SORT = "sort";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
