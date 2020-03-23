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
@TableName(value = "mdc_category")
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

    private static final long serialVersionUID = 4375322416642345116L;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类级别 0>1级 1>2级
     */
    @TableField(value = "level")
    private Short level;

    /**
     * 单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 关键字
     */
    @TableField(value = "keyword")
    private String keyword;

    /**
     * 上级分类编号 0 表示一级分类
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Boolean state;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_LEVEL = "level";

    public static final String COL_UNIT = "unit";

    public static final String COL_ICON = "icon";

    public static final String COL_KEYWORD = "keyword";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_SORT = "sort";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
