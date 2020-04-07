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
@TableName(value = "mac_business_subscribe")
public class BusinessSubscribe extends BaseEntity {

    private static final long serialVersionUID = 5642793749759821001L;

    /**
     * 用户昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 联系方式
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 预约洽谈事项
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Short state;

    /**
     * 创建人id
     */
    @TableField(value = "create_id")
    private Long createId;

    public static final String COL_ID = "id";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_REAL_NAME = "real_name";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_REMARK = "remark";

    public static final String COL_STATE = "state";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CREATE_ID = "create_id";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
