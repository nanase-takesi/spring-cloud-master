package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BucketDto;
import com.shengda.provider.service.BucketService;
import com.shengda.query.BucketQuery;
import com.shengda.vo.BucketVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 * @date 2020-03-26
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/bucket")
public class BucketController extends BaseController {

    private final BucketService bucketService;

    @GetMapping(value = "/list")
    public PageWrapper listBucket(BucketQuery bucketQuery) {
        IPage<BucketVo> result = bucketService.list(bucketQuery);
        return PageWrapMapper.wrap(result.getRecords(),
                result.getCurrent(), result.getPages(), result.getTotal());
    }

    @PostMapping(value = "/add")
    public Wrapper<String> addBucket(@RequestBody BucketDto bucketDto) {
        bucketService.add(bucketDto);
        return WrapMapper.ok();
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper<String> deleteBucket(@PathVariable Long id) {
        bucketService.delete(id);
        return WrapMapper.ok();
    }

}
