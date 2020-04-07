package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessCard;
import com.shengda.query.BusinessCardQuery;
import com.shengda.vo.BusinessCardVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessCardMapper extends BaseMapper<BusinessCard> {

    /**
     * 分页查询名片
     *
     * @param page              page
     * @param businessCardQuery businessCardQuery
     * @return IPage<BusinessCardVo>
     */
    IPage<BusinessCardVo> queryPage(IPage<BusinessCardVo> page, @Param("query") BusinessCardQuery businessCardQuery);

    /**
     * 查询名片信息
     *
     * @param name name
     * @return List<BusinessCardVo>
     */
    List<BusinessCardVo> queryBusinessCards(@Param("name") String name);

    /**
     * 查询名片信息
     *
     * @param cardId cardId
     * @return BusinessCardVo
     */
    BusinessCardVo queryById(Long cardId);
}