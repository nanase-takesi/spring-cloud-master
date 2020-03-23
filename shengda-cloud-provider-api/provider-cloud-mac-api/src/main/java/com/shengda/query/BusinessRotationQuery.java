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
public class BusinessRotationQuery extends BaseQuery {

    private static final long serialVersionUID = 3030602119284993770L;

    private String name;

    private Short state;

}
