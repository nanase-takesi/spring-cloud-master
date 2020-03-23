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
public class BusinessVideoQuery extends BaseQuery {

    private static final long serialVersionUID = 8813718505312591705L;

    private String title;

    private Short state;

}
