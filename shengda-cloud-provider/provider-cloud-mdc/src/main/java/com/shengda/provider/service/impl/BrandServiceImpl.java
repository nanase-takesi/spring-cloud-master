package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BrandDto;
import com.shengda.enums.MdcErrorCodeEnum;
import com.shengda.exception.MdcBizException;
import com.shengda.provider.mapper.BrandMapper;
import com.shengda.provider.model.domain.Brand;
import com.shengda.provider.model.enums.BrandState;
import com.shengda.provider.service.BrandService;
import com.shengda.query.BrandQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.util.Pinyin4jUtils;
import com.shengda.vo.BrandVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public void add(BrandDto brandDto) {
        Brand brand = CachedBeanCopierUtils.copyBean(brandDto, Brand.class);
        assert brand != null;
        brand.setFirstLetter(Pinyin4jUtils.getFirstSpellPinYin(brand.getName(), true));
        brand.setState(BrandState.IN_USE.getValue());
        brandMapper.insert(brand);
    }

    @Override
    public void update(Long id, BrandDto brandDto) {
        Brand brand = brandMapper.selectById(id);

        if (!Objects.isNull(brand)) {
            CachedBeanCopierUtils.copy(brandDto, brand);
            brand.setFirstLetter(Pinyin4jUtils.getFirstSpellPinYin(brand.getName(), true));
            brandMapper.updateById(brand);
        } else {
            throw new MdcBizException(MdcErrorCodeEnum.MAC100600404);
        }
    }

    @Override
    public void changeState(Long id, BrandState state) {
        Brand brand = brandMapper.queryById(id);

        if (!Objects.isNull(brand)) {
            if (state == BrandState.INVALID) {
                brandMapper.deleteById(id);
            } else {
                brand.setState(BrandState.IN_USE.getValue());
                brandMapper.updateStateById(id, BrandState.IN_USE, brand.getVersion());
            }
        } else {
            throw new MdcBizException(MdcErrorCodeEnum.MAC100600404);
        }
    }

}
