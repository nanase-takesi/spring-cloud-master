package com.shengda.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shengda.mybatis.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Data
@TableName(value = "uac_bucket")
@EqualsAndHashCode(callSuper = false)
public class Bucket extends BaseEntity {

    private static final long serialVersionUID = -9094344094959656576L;

    /**
     * 数据存储桶名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 存储类型
     */
    @TableField(value = "type")
    private Short type;

    @TableField(value = "remark")
    private String remark;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_TYPE = "type";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";
}
