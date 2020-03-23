package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RotationQuery extends BaseQuery {

    private static final long serialVersionUID = -2473261965366646079L;

    private String name;

    private Short state;

}
