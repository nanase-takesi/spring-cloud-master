package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Rotation;
import com.shengda.query.RotationQuery;
import com.shengda.vo.RotationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface RotationMapper extends BaseMapper<Rotation> {

    /**
     * 分页查询轮播图
     *
     * @param page          page
     * @param rotationQuery rotationQuery
     * @return IPage<RotationVo>
     */
    IPage<RotationVo> queryPage(IPage<RotationVo> page, @Param("query") RotationQuery rotationQuery);

    /**
     * 批量更新轮播图
     *
     * @param result result
     */
    void batchUpdate(@Param("list") List<Rotation> result);
}
