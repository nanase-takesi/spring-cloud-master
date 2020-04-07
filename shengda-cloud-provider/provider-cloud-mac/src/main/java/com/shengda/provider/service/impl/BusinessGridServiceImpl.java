package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessGridDto;
import com.shengda.dto.BusinessGridEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessGridMapper;
import com.shengda.provider.model.domain.BusinessGrid;
import com.shengda.provider.service.BusinessGridService;
import com.shengda.query.BusinessGridQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessGridVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600061;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600062;
import static com.shengda.provider.model.enums.BusinessGridState.INVALID;
import static com.shengda.provider.model.enums.BusinessGridState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessGridServiceImpl extends ServiceImpl<BusinessGridMapper, BusinessGrid> implements BusinessGridService {

    private final BusinessGridMapper businessGridMapper;

    @Override
    public IPage<BusinessGridVo> list(BusinessGridQuery businessGridQuery) {
        IPage<BusinessGridVo> page = new Page<>(businessGridQuery.getCurrent(), businessGridQuery.getPageSize());
        return businessGridMapper.queryPage(page, businessGridQuery);
    }

    @Override
    public void add(BusinessGridDto businessGridDto) {
        BusinessGrid businessGrid = new BusinessGrid();
        CachedBeanCopierUtils.copy(businessGridDto, businessGrid);
        businessGrid.setState(IN_USE.getValue());
        int flag = businessGridMapper.insert(businessGrid);

        if (flag <= 0) {
            throw new MacBizException(MAC100600061);
        }
    }

    @Override
    public void update(Long id, BusinessGridEditDto businessGridEditDto) {
        BusinessGrid businessGrid = businessGridMapper.selectById(id);

        if (!Objects.isNull(businessGrid)) {
            CachedBeanCopierUtils.copy(businessGridEditDto, businessGrid);
            businessGridMapper.updateById(businessGrid);
        } else {
            throw new MacBizException(MAC100600062);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessGrid businessGrid = businessGridMapper.selectById(id);

        if (!Objects.isNull(businessGrid)) {
            businessGrid.setState(INVALID.getValue());
            businessGridMapper.updateById(businessGrid);
        } else {
            throw new MacBizException(MAC100600062);
        }
    }

    @Override
    public List<BusinessGridVo> queryByCardId(Long cardId) {
        return businessGridMapper.queryByCardId(cardId);
    }
}
