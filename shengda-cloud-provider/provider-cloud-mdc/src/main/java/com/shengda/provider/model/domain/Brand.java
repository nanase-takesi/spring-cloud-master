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
@TableName(value = "mdc_brand")
@EqualsAndHashCode(callSuper = false)
public class Brand extends BaseEntity {

    private static final long serialVersionUID = 5282618955808506664L;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 首字母
     */
    @TableField(value = "first_letter")
    private String firstLetter;

    /**
     * 品牌logo
     */
    @TableField(value = "logo")
    private String logo;

    /**
     * 大图专区
     */
    @TableField(value = "big_picture")
    private String bigPicture;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @TableField(value = "is_factory")
    private Boolean isFactory;

    /**
     * 品牌故事
     */
    @TableField(value = "story")
    private String story;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Boolean state;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_FIRST_LETTER = "first_letter";

    public static final String COL_LOGO = "logo";

    public static final String COL_BIG_PICTURE = "big_picture";

    public static final String COL_SORT = "sort";

    public static final String COL_IS_FACTORY = "is_factory";

    public static final String COL_STORY = "story";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
