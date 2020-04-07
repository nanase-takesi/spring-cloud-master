package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.RotationDto;
import com.shengda.enums.MacErrorCodeEnum;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.RotationMapper;
import com.shengda.provider.model.domain.Rotation;
import com.shengda.provider.model.enums.RotationState;
import com.shengda.provider.service.RotationService;
import com.shengda.query.RotationQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.RotationVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class RotationServiceImpl extends ServiceImpl<RotationMapper, Rotation> implements RotationService {

    private final RotationMapper rotationMapper;

    @Override
    public IPage<RotationVo> list(RotationQuery rotationQuery) {
        IPage<RotationVo> page = new Page<>(rotationQuery.getCurrent(), rotationQuery.getPageSize());
        return rotationMapper.queryPage(page, rotationQuery);
    }

    @Override
    public void add(RotationDto rotationDto) {
        Rotation rotation = new Rotation();
        CachedBeanCopierUtils.copy(rotationDto, rotation);
        rotation.setCreateId(1L);
        rotation.setState(RotationState.IN_USE.getValue());
        int flag = rotationMapper.insert(rotation);

        if (flag <= 0) {
            throw new MacBizException(MacErrorCodeEnum.MAC100600500);
        }
    }

    @Override
    public void update(Long id, RotationDto rotationDto) {
        Rotation rotation = rotationMapper.selectById(id);

        if (!Objects.isNull(rotation)) {
            CachedBeanCopierUtils.copy(rotationDto, rotation);
            rotationMapper.updateById(rotation);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

    @Override
    public void changeState(Long id, RotationState state) {
        Rotation rotation = rotationMapper.selectById(id);

        if (!Objects.isNull(rotation)) {
            rotation.setState(state.getValue());
            rotationMapper.updateById(rotation);
        } else {
            throw new MacBizException(MacErrorCodeEnum.MAC100600404);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDelete(List<Long> ids) {
        List<Rotation> result = rotationMapper.selectBatchIds(ids);
        if (result.size() > 0) {
            result.forEach(item -> item.setState(RotationState.INVALID.getValue()));
        }
        rotationMapper.batchUpdate(result);
        throw new MacBizException(MacErrorCodeEnum.MAC100600404);
    }

}
