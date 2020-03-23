package com.shengda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Data
public class SystemNoticeVo implements Serializable {

    private static final long serialVersionUID = 4031237608033836165L;

    private Long id;

    private String name;

    private String url;

    private Integer sort;

    private Short state;

}
