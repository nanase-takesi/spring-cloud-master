package com.shengda.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Data
public class DepartmentDto implements Serializable {

    private static final long serialVersionUID = -3461166372961481563L;

    /**
     * 部门名称
     */
    @NotBlank
    @Length(min = 1, max = 50)
    private String name;

    /**
     * 部门简称
     */
    private String shortName;

    /**
     * 部门负责人id
     */
    private Long managerId;

    /**
     * 部门负级id
     */
    private Long parentId;

}
