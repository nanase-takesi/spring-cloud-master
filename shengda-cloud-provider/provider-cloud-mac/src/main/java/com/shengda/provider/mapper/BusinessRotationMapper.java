package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessRotation;
import com.shengda.query.BusinessRotationQuery;
import com.shengda.vo.BusinessRotationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessRotationMapper extends BaseMapper<BusinessRotation> {

    /**
     * 分页查询名片轮播
     *
     * @param page                  page
     * @param businessRotationQuery businessRotationQuery
     * @return IPage<BusinessRotationVo>
     */
    IPage<BusinessRotationVo> queryPage(IPage<BusinessRotationVo> page, @Param("query") BusinessRotationQuery businessRotationQuery);

    /**
     * 根据卡片id查询轮播
     *
     * @param cardId cardId
     * @return List<BusinessRotationVo>
     */
    List<BusinessRotationVo> queryByCardId(Long cardId);
}
