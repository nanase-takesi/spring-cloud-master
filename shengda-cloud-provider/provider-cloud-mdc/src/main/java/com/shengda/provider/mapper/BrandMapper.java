package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Brand;
import com.shengda.query.BrandQuery;
import com.shengda.vo.BrandVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 分页查询
     *
     * @param page       page
     * @param brandQuery brandQuery
     * @return IPage<BrandVo>
     */
    IPage<BrandVo> queryBrand(IPage<BrandVo> page, @Param("query") BrandQuery brandQuery);
}
