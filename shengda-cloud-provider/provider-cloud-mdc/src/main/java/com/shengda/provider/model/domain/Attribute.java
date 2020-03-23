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
@TableName(value = "mdc_attribute")
@EqualsAndHashCode(callSuper = false)
public class Attribute extends BaseEntity {

    private static final long serialVersionUID = 5890157482227143831L;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类id
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；
     */
    @TableField(value = "select_type")
    private Short selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @TableField(value = "input_type")
    private Boolean inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @TableField(value = "input_list")
    private String inputList;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @TableField(value = "filter_type")
    private Boolean filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @TableField(value = "search_type")
    private Short searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @TableField(value = "is_related")
    private Boolean isRelated;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @TableField(value = "is_hand_add")
    private Boolean isHandAdd;

    /**
     * 属性的类型；0->规格；1->参数
     */
    @TableField(value = "type")
    private Boolean type;

    /**
     * 排序值
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

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_SELECT_TYPE = "select_type";

    public static final String COL_INPUT_TYPE = "input_type";

    public static final String COL_INPUT_LIST = "input_list";

    public static final String COL_FILTER_TYPE = "filter_type";

    public static final String COL_SEARCH_TYPE = "search_type";

    public static final String COL_IS_RELATED = "is_related";

    public static final String COL_IS_HAND_ADD = "is_hand_add";

    public static final String COL_TYPE = "type";

    public static final String COL_SORT = "sort";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
