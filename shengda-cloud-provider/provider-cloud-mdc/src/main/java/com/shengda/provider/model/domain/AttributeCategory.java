package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "mdc_attribute_category")
public class AttributeCategory extends BaseEntity {

    private static final long serialVersionUID = -7828842324353288229L;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Boolean state;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
