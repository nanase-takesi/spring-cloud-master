package com.shengda.query;

import com.shengda.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 * @date 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxUserInfoQuery extends BaseQuery {

    private static final long serialVersionUID = -8265570523435280221L;

    private String nickname;

    private Short state;

}
