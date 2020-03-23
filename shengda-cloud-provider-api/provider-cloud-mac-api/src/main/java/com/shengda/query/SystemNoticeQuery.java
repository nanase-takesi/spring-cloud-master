package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SystemNoticeQuery extends BaseQuery {

    private static final long serialVersionUID = -5795231898936703815L;

    private String name;

    private Short state;

}
