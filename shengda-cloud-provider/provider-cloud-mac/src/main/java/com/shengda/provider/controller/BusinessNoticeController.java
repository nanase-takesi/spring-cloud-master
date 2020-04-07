package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessNoticeDto;
import com.shengda.dto.BusinessNoticeEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessNoticeService;
import com.shengda.query.BusinessNoticeQuery;
import com.shengda.vo.BusinessNoticeVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 * @date 2019-12-27
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/business/notice")
public class BusinessNoticeController extends BaseController {

    private final BusinessNoticeService businessNoticeService;

    @GetMapping(value = "/list")
    public PageWrapper list(BusinessNoticeQuery businessNoticeQuery) {
        IPage<BusinessNoticeVo> result = businessNoticeService.list(businessNoticeQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(), result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/add")
    public Wrapper add(@RequestBody BusinessNoticeDto businessNoticeDto) {
        try {
            businessNoticeService.add(businessNoticeDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessNoticeEditDto businessNoticeEditDto) {
        try {
            businessNoticeService.update(id, businessNoticeEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessNoticeService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

}
