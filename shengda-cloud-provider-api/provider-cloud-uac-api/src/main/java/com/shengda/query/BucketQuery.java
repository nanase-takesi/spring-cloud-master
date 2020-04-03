package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BucketQuery extends BaseQuery {

    private static final long serialVersionUID = -3503862326923048214L;

    private String name;

    private Short type;

}
