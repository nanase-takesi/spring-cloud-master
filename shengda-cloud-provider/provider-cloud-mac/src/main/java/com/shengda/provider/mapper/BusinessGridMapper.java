package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessGrid;
import com.shengda.query.BusinessGridQuery;
import com.shengda.vo.BusinessGridVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessGridMapper extends BaseMapper<BusinessGrid> {

    /**
     * 分页查询名片图标
     *
     * @param page              page
     * @param businessGridQuery businessGridQuery
     * @return IPage<BusinessGridVo>
     */
    IPage<BusinessGridVo> queryPage(IPage<BusinessGridVo> page, @Param("query") BusinessGridQuery businessGridQuery);

    /**
     * 查询图标
     *
     * @param cardId cardId
     * @return List<BusinessGridVo>
     */
    List<BusinessGridVo> queryByCardId(@Param("cardId") Long cardId);
}
