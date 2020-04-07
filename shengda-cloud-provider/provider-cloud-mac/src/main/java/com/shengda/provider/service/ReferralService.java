package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.ReferralDto;
import com.shengda.provider.model.domain.Referral;
import com.shengda.provider.model.enums.ReferralState;
import com.shengda.query.ReferralQuery;
import com.shengda.vo.ReferralVo;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface ReferralService extends IService<Referral> {

    /**
     * 分页查询推荐位
     *
     * @param referralQuery recommendedQuery
     * @return IPage<RecommendedVo>
     */
    IPage<ReferralVo> list(ReferralQuery referralQuery);

    /**
     * 新增推荐位
     *
     * @param referralDto recommendedDto
     */
    void add(ReferralDto referralDto);

    /**
     * 编辑推荐位
     *
     * @param id          id
     * @param referralDto recommendedDto
     */
    void update(Long id, ReferralDto referralDto);

    /**
     * 删除轮播图
     *
     * @param id    id
     * @param state state
     */
    void changeState(Long id, ReferralState state);
}
