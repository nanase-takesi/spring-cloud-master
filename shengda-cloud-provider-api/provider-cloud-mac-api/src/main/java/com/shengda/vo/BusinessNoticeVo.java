package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
public class BusinessNoticeVo implements Serializable {

    private static final long serialVersionUID = 3558503361388470706L;

    private Long id;

    /**
     * 公告内容
     */
    private String name;

    /**
     * 跳转连接
     */
    private String url;

    /**
     * 名片id
     */
    private Long cardId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Short state;

    /**
     * 备注
     */
    private String remark;

}
