package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessRotationDto;
import com.shengda.dto.BusinessRotationEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessRotationMapper;
import com.shengda.provider.model.domain.BusinessRotation;
import com.shengda.provider.service.BusinessRotationService;
import com.shengda.query.BusinessRotationQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessRotationVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600041;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600042;
import static com.shengda.provider.model.enums.BusinessRotationState.INVALID;
import static com.shengda.provider.model.enums.BusinessRotationState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessRotationServiceImpl extends ServiceImpl<BusinessRotationMapper, BusinessRotation> implements BusinessRotationService {

    private final BusinessRotationMapper businessRotationMapper;

    @Override
    public IPage<BusinessRotationVo> list(BusinessRotationQuery businessRotationQuery) {
        IPage<BusinessRotationVo> page = new Page<>(businessRotationQuery.getCurrent(),
                businessRotationQuery.getPageSize());
        return businessRotationMapper.queryPage(page, businessRotationQuery);
    }

    @Override
    public void add(BusinessRotationDto businessRotationDto) {
        BusinessRotation businessRotation = new BusinessRotation();
        CachedBeanCopierUtils.copy(businessRotationDto, businessRotation);
        businessRotation.setState(IN_USE.getValue());
        businessRotation.setCreateId(1L);
        int flag = businessRotationMapper.insert(businessRotation);

        if (flag <= 0) {
            throw new MacBizException(MAC100600041);
        }
    }

    @Override
    public void update(Long id, BusinessRotationEditDto businessRotationEditDto) {
        BusinessRotation businessRotation = businessRotationMapper.selectById(id);

        if (!Objects.isNull(businessRotation)) {
            CachedBeanCopierUtils.copy(businessRotationEditDto, businessRotation);
            businessRotationMapper.updateById(businessRotation);
        } else {
            throw new MacBizException(MAC100600042);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessRotation businessRotation = businessRotationMapper.selectById(id);

        if (!Objects.isNull(businessRotation)) {
            businessRotation.setState(INVALID.getValue());
            businessRotationMapper.updateById(businessRotation);
        } else {
            throw new MacBizException(MAC100600042);
        }
    }

    @Override
    public List<BusinessRotationVo> getByCardId(Long cardId) {
        return businessRotationMapper.queryByCardId(cardId);
    }
}
