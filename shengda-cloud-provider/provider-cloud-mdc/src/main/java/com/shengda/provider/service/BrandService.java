package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.query.BrandQuery;
import com.shengda.vo.BrandVo;

/**
 * @author takesi
 * @date 2020-03-19
 */
public interface BrandService extends IService<Brand> {

    /**
     * 分页查询品牌信息
     *
     * @param brandQuery brandQuery
     * @return IPage<BrandVo>
     */
    IPage<BrandVo> list(BrandQuery brandQuery);

}
