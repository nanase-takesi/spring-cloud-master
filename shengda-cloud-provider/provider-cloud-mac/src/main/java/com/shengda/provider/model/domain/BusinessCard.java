package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "mac_business_card")
public class BusinessCard extends BaseEntity {

    private static final long serialVersionUID = -422088456231250488L;

    /**
     * 名片名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 绑定用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 绑定用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 上传封面图
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 联系方式
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 有效起始时间
     */
    @TableField(value = "expire_start_time")
    private Date expireStartTime;

    /**
     * 有效结束时间
     */
    @TableField(value = "expire_end_time")
    private Date expireEndTime;

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

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_IMAGES_URL = "images_url";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_EXPIRE_START_TIME = "expire_start_time";

    public static final String COL_EXPIRE_END_TIME = "expire_end_time";

    public static final String COL_STATE = "state";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
