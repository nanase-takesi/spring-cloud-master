package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleQuery extends BaseQuery {

    private static final long serialVersionUID = -4463150422714537552L;

    private String code;

    private String name;

}
