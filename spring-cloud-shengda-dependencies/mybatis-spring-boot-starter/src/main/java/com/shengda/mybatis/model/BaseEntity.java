package com.shengda.mybatis.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-01-22
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8272592456624077045L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", updateStrategy = FieldStrategy.NOT_NULL,
            fill = FieldFill.UPDATE, update = "CURRENT_TIMESTAMP")
    private Date updateTime;

    /**
     * 版本号
     */
    @Version
    @TableField(value = "version", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer version;

}
