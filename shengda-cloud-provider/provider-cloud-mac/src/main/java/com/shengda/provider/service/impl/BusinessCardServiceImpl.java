package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessCardDto;
import com.shengda.dto.BusinessCardEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessCardMapper;
import com.shengda.provider.model.domain.BusinessCard;
import com.shengda.provider.service.BusinessCardService;
import com.shengda.query.BusinessCardQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessCardVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600031;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600032;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600033;
import static com.shengda.provider.model.domain.BusinessCard.COL_USER_ID;
import static com.shengda.provider.model.enums.BusinessCardState.INVALID;
import static com.shengda.provider.model.enums.BusinessCardState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessCardServiceImpl extends ServiceImpl<BusinessCardMapper, BusinessCard> implements BusinessCardService {

    private final BusinessCardMapper businessCardMapper;

    @Override
    public IPage<BusinessCardVo> list(BusinessCardQuery businessCardQuery) {
        IPage<BusinessCardVo> page = new Page<>(businessCardQuery.getCurrent(), businessCardQuery.getPageSize());
        return businessCardMapper.queryPage(page, businessCardQuery);
    }

    @Override
    public List<BusinessCardVo> list(String name) {
        return businessCardMapper.queryBusinessCards(name);
    }

    @Override
    public void add(BusinessCardDto businessCardDto) {
        QueryWrapper<BusinessCard> wrapper = new QueryWrapper<>();
        wrapper.eq(COL_USER_ID, businessCardDto.getUserId());
        int count = businessCardMapper.selectCount(wrapper);

        if (count <= 0) {
            BusinessCard businessCard = new BusinessCard();
            CachedBeanCopierUtils.copy(businessCardDto, businessCard);
            businessCard.setState(IN_USE.getValue());
            int flag = businessCardMapper.insert(businessCard);

            if (flag <= 0) {
                throw new MacBizException(MAC100600031);
            }
        } else {
            throw new MacBizException(MAC100600032);
        }
    }

    @Override
    public void update(Long id, BusinessCardEditDto businessCardEditDto) {
        BusinessCard businessCard = businessCardMapper.selectById(id);

        if (!Objects.isNull(businessCard)) {
            CachedBeanCopierUtils.copy(businessCardEditDto, businessCard);
            businessCardMapper.updateById(businessCard);
        } else {
            throw new MacBizException(MAC100600033);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessCard businessCard = businessCardMapper.selectById(id);

        if (!Objects.isNull(businessCard)) {
            businessCard.setState(INVALID.getValue());
            businessCardMapper.updateById(businessCard);
        } else {
            throw new MacBizException(MAC100600033);
        }
    }
}
