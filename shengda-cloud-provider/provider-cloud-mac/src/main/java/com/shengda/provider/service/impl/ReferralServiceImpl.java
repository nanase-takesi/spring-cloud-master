package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.ReferralDto;
import com.shengda.enums.MacErrorCodeEnum;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.ReferralMapper;
import com.shengda.provider.model.domain.Referral;
import com.shengda.provider.model.enums.ReferralState;
import com.shengda.provider.service.ReferralService;
import com.shengda.query.ReferralQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.ReferralVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class ReferralServiceImpl extends ServiceImpl<ReferralMapper, Referral> implements ReferralService {

    private final ReferralMapper referralMapper;

    @Override
    public IPage<ReferralVo> list(ReferralQuery referralQuery) {
        IPage<ReferralVo> page = new Page<>(referralQuery.getCurrent(), referralQuery.getPageSize());
        return referralMapper.queryPage(page, referralQuery);
    }

    @Override
    public void add(ReferralDto referralDto) {
        Referral referral = new Referral();
        CachedBeanCopierUtils.copy(referralDto, referral);
        referral.setCreateId(1L);
        referral.setState(ReferralState.IN_USE.getValue());
        int flag = referralMapper.insert(referral);

        if (flag <= 0) {
            throw new MacBizException(MacErrorCodeEnum.MAC100600500);
        }
    }

    @Override
    public void update(Long id, ReferralDto referralDto) {
        Referral referral = referralMapper.selectById(id);

        if (!Objects.isNull(referral)) {
            CachedBeanCopierUtils.copy(referralDto, referral);
            referralMapper.updateById(referral);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

    @Override
    public void changeState(Long id, ReferralState state) {
        Referral referral = referralMapper.selectById(id);

        if (!Objects.isNull(referral)) {
            referral.setState(state.getValue());
            referralMapper.updateById(referral);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

}
