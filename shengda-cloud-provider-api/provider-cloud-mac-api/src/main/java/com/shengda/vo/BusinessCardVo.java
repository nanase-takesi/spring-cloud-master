package com.shengda.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class BusinessCardVo implements Serializable {

    private static final long serialVersionUID = -943687484575111079L;

    private Long id;

    /**
     * 名片名称
     */
    private String name;

    /**
     * 绑定用户id
     */
    private Long userId;

    /**
     * 绑定用户名称
     */
    private String userName;

    /**
     * 上传封面图
     */
    private String imageUrl;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 有效起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireStartTime;

    /**
     * 有效结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireEndTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 状态
     */
    private Short state;

    /**
     * 备注
     */
    private String remark;

}
