package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Data
public class RoleVo implements Serializable {

    private static final long serialVersionUID = -4028940046828176194L;

    private Long id;

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名
     */
    private String name;

    /**
     * 租户字段
     */
    private String tenantId;

    private Date createTime;

    private Date updateTime;

}
