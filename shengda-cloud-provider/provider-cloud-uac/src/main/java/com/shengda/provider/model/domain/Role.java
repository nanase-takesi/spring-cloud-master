package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Data
@TableName(value = "uac_role")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 8432826525772308157L;

    /**
     * 角色code
     */
    @TableField(value = "code")
    private String code;

    /**
     * 角色名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 租户字段
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    public static final String COL_ID = "id";

    public static final String COL_CODE = "code";

    public static final String COL_NAME = "name";

    public static final String COL_TENANT_ID = "tenant_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
