package com.shengda.provider.model.domain;

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
@EqualsAndHashCode(callSuper = false)
@TableName(value = "mac_business_notice")
public class BusinessNotice extends BaseEntity {

    private static final long serialVersionUID = 8913008152318857003L;

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
     * 名片id
     */
    @TableField(value = "card_id")
    private Long cardId;

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

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_URL = "url";

    public static final String COL_CARD_ID = "card_id";

    public static final String COL_SORT = "sort";

    public static final String COL_STATE = "state";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
