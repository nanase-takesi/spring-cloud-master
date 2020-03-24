package com.shengda.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentUpdateDto extends DepartmentDto {

    private static final long serialVersionUID = -2924740470835877988L;

    @NotNull
    private Long id;

}
