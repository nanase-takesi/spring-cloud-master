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
public class BusinessArticleQuery extends BaseQuery {

    private static final long serialVersionUID = -1002174902396448205L;

    private String title;

    private Short state;

}
