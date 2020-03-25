package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PositionQuery extends BaseQuery {

    private static final long serialVersionUID = 4117677502838324283L;

    private String name;

    private Boolean state;

}
