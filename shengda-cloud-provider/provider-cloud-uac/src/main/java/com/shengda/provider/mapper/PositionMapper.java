package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Position;
import com.shengda.query.PositionQuery;
import com.shengda.vo.PositionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Mapper
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 分页查询岗位
     *
     * @param page          page
     * @param positionQuery positionQuery
     * @return IPage<PositionVo>
     */
    IPage<PositionVo> queryPosition(IPage<PositionVo> page, @Param("query") PositionQuery positionQuery);

    /**
     * 查询岗位信息
     *
     * @param id id
     * @return PositionVo
     */
    PositionVo queryById(@Param("id") Long id);
}
