package com.shengda.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PositionUpdateDto extends PositionDto {

    private static final long serialVersionUID = -6446693048642026066L;

    @NotNull
    private Long id;

}
