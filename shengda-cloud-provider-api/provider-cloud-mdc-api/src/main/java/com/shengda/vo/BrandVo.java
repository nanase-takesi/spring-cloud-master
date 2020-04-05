package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Data
public class BrandVo implements Serializable {

    private static final long serialVersionUID = -5818204779002850723L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 首字母
     */
    private String firstLetter;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 大图专区
     */
    private String bigPicture;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    private Boolean isFactory;

    /**
     * 品牌故事
     */
    private String story;

    /**
     * 状态
     */
    private Boolean state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
