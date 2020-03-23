package com.shengda.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-01-10
 */
@Data
@Builder
public class MemberLoginVo implements Serializable {

    private static final long serialVersionUID = -7871760035916967900L;

    private MemberVo member;

    private BusinessCardVo businessCard;

    private WxUserInfoVo wxUserInfo;

}
