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
public class BusinessCardQuery extends BaseQuery {

    private static final long serialVersionUID = 5928728716606031622L;

    private Long userId;

    private Short state;

}
