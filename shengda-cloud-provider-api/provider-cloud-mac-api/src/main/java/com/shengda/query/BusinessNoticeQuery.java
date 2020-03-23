package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessNoticeQuery extends BaseQuery {

    private static final long serialVersionUID = 4617556377699336958L;

    private String name;

    private Short state;

}
