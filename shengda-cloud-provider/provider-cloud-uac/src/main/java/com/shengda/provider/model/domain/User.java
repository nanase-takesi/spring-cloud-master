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
@TableName(value = "uac_user")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    private static final long serialVersionUID = 710291188142376875L;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "head_img_url")
    private String headImgUrl;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "sex")
    private Boolean sex;

    @TableField(value = "enabled")
    private Boolean enabled;

    @TableField(value = "type")
    private String type;

    @TableField(value = "company")
    private String company;

    @TableField(value = "open_id")
    private String openId;

    @TableField(value = "is_del")
    private Boolean isDel;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_HEAD_IMG_URL = "head_img_url";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_SEX = "sex";

    public static final String COL_ENABLED = "enabled";

    public static final String COL_TYPE = "type";

    public static final String COL_COMPANY = "company";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_IS_DEL = "is_del";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
