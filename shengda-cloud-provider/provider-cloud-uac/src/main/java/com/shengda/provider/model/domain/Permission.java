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
@TableName(value = "uac_permission")
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 2578510808707302578L;

    @TableField(value = "name")
    private String name;

    @TableField(value = "url")
    private String url;

    @TableField(value = "path")
    private String path;

    @TableField(value = "path_method")
    private String pathMethod;

    @TableField(value = "css")
    private String css;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "sort")
    private Integer sort;

    @TableField(value = "type")
    private Boolean type;

    @TableField(value = "hidden")
    private Boolean hidden;

    /**
     * 租户字段
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_URL = "url";

    public static final String COL_PATH = "path";

    public static final String COL_PATH_METHOD = "path_method";

    public static final String COL_CSS = "css";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_SORT = "sort";

    public static final String COL_TYPE = "type";

    public static final String COL_HIDDEN = "hidden";

    public static final String COL_TENANT_ID = "tenant_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
