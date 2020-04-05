package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.BrandMapper;
import com.shengda.provider.model.domain.Brand;
import com.shengda.provider.service.BrandService;
import com.shengda.query.BrandQuery;
import com.shengda.vo.BrandVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Service
@AllArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    private final BrandMapper brandMapper;

    @Override
    public IPage<BrandVo> list(BrandQuery brandQuery) {
        IPage<BrandVo> page = new Page<>(brandQuery.getCurrent(), brandQuery.getPageSize());
        return brandMapper.queryBrand(page, brandQuery);
    }
}
