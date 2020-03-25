package com.shengda.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Data
public class PositionDto implements Serializable {

    private static final long serialVersionUID = 3840141864600099134L;

    /**
     * 岗位名称
     */
    @NotBlank
    @Length(min = 1, max = 32)
    private String name;

    /**
     * 岗位描述
     */
    @NotBlank
    @Length(min = 1)
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

}
