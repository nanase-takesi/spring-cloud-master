package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BrandQuery extends BaseQuery {

    private static final long serialVersionUID = -2895224030309876961L;

    private String name;

    private Boolean isFactory;

    private Boolean state;

}
