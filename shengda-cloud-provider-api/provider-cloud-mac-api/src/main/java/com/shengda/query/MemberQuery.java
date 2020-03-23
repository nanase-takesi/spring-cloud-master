package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2020-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberQuery extends BaseQuery {

    private static final long serialVersionUID = -83472055146500535L;

    private String nickname;

}
