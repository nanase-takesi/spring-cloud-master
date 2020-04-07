package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Referral;
import com.shengda.query.ReferralQuery;
import com.shengda.vo.ReferralVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface ReferralMapper extends BaseMapper<Referral> {

    /**
     * 分页查询推荐位
     *
     * @param page             page
     * @param referralQuery recommendedQuery
     * @return IPage<RecommendedVo>
     */
    IPage<ReferralVo> queryPage(IPage<ReferralVo> page, @Param("referralQuery") ReferralQuery referralQuery);
}
