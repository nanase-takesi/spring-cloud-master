package com.shengda.base.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-01-26
 */
@Data
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = -3559632150008054172L;

    private Integer current;

    private Integer pageSize;

}
