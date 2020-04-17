package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.dto.BrandDto;
import com.shengda.provider.model.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.provider.model.enums.BrandState;
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

    /**
     * 新增品牌信息
     *
     * @param brandDto brandDto
     */
    void add(BrandDto brandDto);

    /**
     * 更新品牌信息
     *
     * @param id       id
     * @param brandDto brandDto
     */
    void update(Long id, BrandDto brandDto);

    /**
     * 修改品牌信息状态信息
     *
     * @param id         id
     * @param brandState brandState
     */
    void changeState(Long id, BrandState brandState);
}
