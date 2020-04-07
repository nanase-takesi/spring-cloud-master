package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.RotationDto;
import com.shengda.provider.model.domain.Rotation;
import com.shengda.provider.model.enums.RotationState;
import com.shengda.query.RotationQuery;
import com.shengda.vo.RotationVo;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface RotationService extends IService<Rotation> {

    /**
     * 分页查询轮播图
     *
     * @param rotationQuery rotationQuery
     * @return IPage<RotationVo>
     */
    IPage<RotationVo> list(RotationQuery rotationQuery);

    /**
     * 新增轮播图
     *
     * @param rotationDto rotationDto
     */
    void add(RotationDto rotationDto);

    /**
     * 编辑轮播图
     *
     * @param id          id
     * @param rotationDto rotationDto
     */
    void update(Long id, RotationDto rotationDto);

    /**
     * 改变轮播图状态
     *
     * @param id    id
     * @param state state
     */
    void changeState(Long id, RotationState state);

    /**
     * 批量删除轮播图
     *
     * @param ids ids
     */
    void batchDelete(List<Long> ids);
}
