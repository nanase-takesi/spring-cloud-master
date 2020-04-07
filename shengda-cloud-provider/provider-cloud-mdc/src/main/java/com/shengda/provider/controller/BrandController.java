package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BrandDto;
import com.shengda.provider.service.BrandService;
import com.shengda.query.BrandQuery;
import com.shengda.vo.BrandVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/add")
    public Wrapper<String> addBrand(@RequestBody BrandDto brandDto) {

        return WrapMapper.ok("添加成功");
    }

}
