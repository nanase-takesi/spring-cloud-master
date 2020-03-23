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
public class BusinessGridQuery extends BaseQuery {

    private static final long serialVersionUID = 7231455829901054087L;

    private String name;

    private Short state;

}
