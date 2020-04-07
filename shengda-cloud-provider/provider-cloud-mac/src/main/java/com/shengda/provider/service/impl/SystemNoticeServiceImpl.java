package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.SystemNoticeDto;
import com.shengda.enums.MacErrorCodeEnum;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.SystemNoticeMapper;
import com.shengda.provider.model.domain.SystemNotice;
import com.shengda.provider.model.enums.SystemNoticeState;
import com.shengda.provider.service.SystemNoticeService;
import com.shengda.query.SystemNoticeQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.SystemNoticeVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Service
@AllArgsConstructor
public class SystemNoticeServiceImpl extends ServiceImpl<SystemNoticeMapper, SystemNotice> implements SystemNoticeService {

    private final SystemNoticeMapper systemNoticeMapper;

    @Override
    public void insert(SystemNoticeDto systemNoticeDto) {
        SystemNotice systemNotice = new SystemNotice();
        CachedBeanCopierUtils.copy(systemNoticeDto, systemNotice);
        systemNotice.setState(SystemNoticeState.IN_USE.getValue());
        systemNotice.setCreateId(1L);
        int result = systemNoticeMapper.insert(systemNotice);

        if (result <= 0) {
            throw new MacBizException(MacErrorCodeEnum.MAC100600500);
        }
    }

    @Override
    public IPage<SystemNoticeVo> list(SystemNoticeQuery systemNoticeQuery) {
        IPage<SystemNoticeVo> page = new Page<>(systemNoticeQuery.getCurrent(), systemNoticeQuery.getPageSize());
        return systemNoticeMapper.queryPage(page, systemNoticeQuery);
    }

    @Override
    public void changeState(Long id, SystemNoticeState state) {
        SystemNotice systemNotice = systemNoticeMapper.selectById(id);

        if (!Objects.isNull(systemNotice)) {
            systemNotice.setState(state.getValue());
            systemNoticeMapper.updateById(systemNotice);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

    @Override
    public void update(long id, SystemNoticeDto systemNoticeDto) {
        SystemNotice systemNotice = systemNoticeMapper.selectById(id);

        if (!Objects.isNull(systemNotice)) {
            CachedBeanCopierUtils.copy(systemNoticeDto, systemNotice);
            systemNoticeMapper.updateById(systemNotice);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

}
