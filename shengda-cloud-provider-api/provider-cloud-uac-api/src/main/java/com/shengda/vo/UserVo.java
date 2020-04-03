package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -7546193221633178057L;

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String headImgUrl;

    private String mobile;

    private Boolean sex;

    private Boolean enabled;

    private String type;

    private String company;

    private String openId;

    private Boolean isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
