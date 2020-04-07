package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessNoticeDto;
import com.shengda.dto.BusinessNoticeEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessNoticeMapper;
import com.shengda.provider.model.domain.BusinessNotice;
import com.shengda.provider.service.BusinessNoticeService;
import com.shengda.query.BusinessNoticeQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessNoticeVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600051;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600052;
import static com.shengda.provider.model.enums.BusinessNoticeState.INVALID;
import static com.shengda.provider.model.enums.BusinessNoticeState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessNoticeServiceImpl extends ServiceImpl<BusinessNoticeMapper, BusinessNotice> implements BusinessNoticeService {

    private final BusinessNoticeMapper businessNoticeMapper;

    @Override
    public IPage<BusinessNoticeVo> list(BusinessNoticeQuery businessNoticeQuery) {
        IPage<BusinessNoticeVo> page = new Page<>(businessNoticeQuery.getCurrent(), businessNoticeQuery.getPageSize());
        return businessNoticeMapper.queryPage(page, businessNoticeQuery);
    }

    @Override
    public void add(BusinessNoticeDto businessNoticeDto) {
        BusinessNotice businessNotice = new BusinessNotice();
        CachedBeanCopierUtils.copy(businessNoticeDto, businessNotice);
        businessNotice.setState(IN_USE.getValue());
        int flag = businessNoticeMapper.insert(businessNotice);

        if (flag <= 0) {
            throw new MacBizException(MAC100600051);
        }
    }

    @Override
    public void update(Long id, BusinessNoticeEditDto businessNoticeEditDto) {
        BusinessNotice businessNotice = businessNoticeMapper.selectById(id);

        if (!Objects.isNull(businessNotice)) {
            CachedBeanCopierUtils.copy(businessNoticeEditDto, businessNotice);
            businessNoticeMapper.updateById(businessNotice);
        } else {
            throw new MacBizException(MAC100600052);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessNotice businessNotice = businessNoticeMapper.selectById(id);

        if (!Objects.isNull(businessNotice)) {
            businessNotice.setState(INVALID.getValue());
            businessNoticeMapper.updateById(businessNotice);
        } else {
            throw new MacBizException(MAC100600052);
        }
    }
}
