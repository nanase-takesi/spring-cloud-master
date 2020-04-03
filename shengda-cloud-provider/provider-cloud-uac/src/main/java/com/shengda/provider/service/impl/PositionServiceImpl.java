package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.PositionDto;
import com.shengda.enums.UacBizErrorCode;
import com.shengda.exception.UacBizException;
import com.shengda.provider.mapper.PositionMapper;
import com.shengda.provider.model.domain.Position;
import com.shengda.provider.model.enums.PositionState;
import com.shengda.provider.service.PositionService;
import com.shengda.query.PositionQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.PositionVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Service
@AllArgsConstructor
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    private final PositionMapper positionMapper;

    @Override
    public void add(PositionDto positionDto) {
        Position position = CachedBeanCopierUtils.copyBean(positionDto, Position.class);
        assert position != null;
        position.setState(PositionState.ENABLE.getValue());
        positionMapper.insert(position);
    }

    @Override
    public IPage<PositionVo> list(PositionQuery positionQuery) {
        IPage<PositionVo> page = new Page<>(positionQuery.getCurrent(), positionQuery.getPageSize());
        return positionMapper.queryPosition(page, positionQuery);
    }

    @Override
    public void update(Long id, PositionDto positionDto) {
        Position position = positionMapper.selectById(id);
        if (!Objects.isNull(position)) {
            CachedBeanCopierUtils.copy(positionDto, position);
            positionMapper.updateById(position);
        } else {
            throw new UacBizException(UacBizErrorCode.RESOURCE_NOT_FOUNT);
        }
    }

    @Override
    public PositionVo get(Long id) {
        return positionMapper.queryById(id);
    }

    @Override
    public void delete(Long id) {
        Position position = positionMapper.selectById(id);
        if (!Objects.isNull(position)) {
            position.setState(PositionState.DISABLE.getValue());
            positionMapper.updateById(position);
        } else {
            throw new UacBizException(UacBizErrorCode.RESOURCE_NOT_FOUNT);
        }
    }

    @Override
    public void batchDelete(List<Long> ids) {
        positionMapper.batchUpdate(PositionState.DISABLE.getValue(), ids);
    }
}
