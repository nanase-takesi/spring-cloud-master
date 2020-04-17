package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BrandDto;
import com.shengda.provider.model.domain.Brand;
import com.shengda.provider.model.enums.BrandState;
import com.shengda.provider.service.BrandService;
import com.shengda.query.BrandQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BrandVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-19
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/brand")
public class BrandController extends BaseController {

    private final BrandService brandService;

    @GetMapping(value = "/list")
    public PageWrapper<List<BrandVo>> listBrand(BrandQuery brandQuery) {
        IPage<BrandVo> result = brandService.list(brandQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @GetMapping(value = "/{id}/get")
    public Wrapper<BrandVo> getBrand(@PathVariable Long id) {
        Brand brand = brandService.getById(id);
        BrandVo result = CachedBeanCopierUtils.copyBean(brand, BrandVo.class);
        return WrapMapper.ok(result);
    }

    @PostMapping(value = "/add")
    public Wrapper<String> addBrand(@RequestBody BrandDto brandDto) {
        brandService.add(brandDto);
        return WrapMapper.ok("添加成功");
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper<String> updateBrand(@PathVariable Long id, BrandDto brandDto) {
        brandService.update(id, brandDto);
        return WrapMapper.ok("更新成功");
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper<String> delete(@PathVariable Long id) {
        brandService.changeState(id, BrandState.INVALID);
        return WrapMapper.ok("删除成功");
    }

    @PatchMapping(value = "/{id}/un_delete")
    public Wrapper<String> unDelete(@PathVariable Long id) {
        brandService.changeState(id, BrandState.IN_USE);
        return WrapMapper.ok("取消删除成功");
    }

}
