package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.dto.PositionDto;
import com.shengda.dto.PositionUpdateDto;
import com.shengda.provider.model.domain.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.query.PositionQuery;
import com.shengda.vo.PositionVo;

/**
 * @author takesi
 * @date 2020-03-24
 */
public interface PositionService extends IService<Position> {

    /**
     * 添加岗位
     *
     * @param positionDto positionDto
     */
    void add(PositionDto positionDto);

    /**
     * 分页查询岗位
     *
     * @param positionQuery positionQuery
     * @return IPage<PositionVo>
     */
    IPage<PositionVo> list(PositionQuery positionQuery);

    /**
     * 更新岗位
     *
     * @param positionUpdateDto positionUpdateDto
     */
    void update(PositionUpdateDto positionUpdateDto);

    /**
     * 查询岗位信息
     *
     * @param id id
     * @return PositionVo
     */
    PositionVo get(Long id);

    /**
     * 删除岗位信息
     *
     * @param id id
     */
    void delete(Long id);
}
