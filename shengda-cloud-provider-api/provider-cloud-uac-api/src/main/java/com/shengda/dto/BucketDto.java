package com.shengda.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Data
public class BucketDto implements Serializable {

    private static final long serialVersionUID = 3352717170114068036L;

    /**
     * 数据存储桶名称
     */
    @NotBlank
    private String name;

    /**
     * 存储类型
     */
    @NotNull
    private Short type;

    /**
     * 备注
     */
    private String remark;

}
