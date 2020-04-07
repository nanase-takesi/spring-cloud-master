package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessCardDto;
import com.shengda.dto.BusinessCardEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessCardService;
import com.shengda.query.BusinessCardQuery;
import com.shengda.vo.BusinessCardVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/business/card")
public class BusinessCardController extends BaseController {

    private final BusinessCardService businessCardService;

    @GetMapping(value = "/list")
    public PageWrapper list(BusinessCardQuery businessCardQuery) {
        IPage<BusinessCardVo> result = businessCardService.list(businessCardQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @GetMapping(value = "/all")
    public Wrapper list(String name) {
        List<BusinessCardVo> result = businessCardService.list(name);
        return WrapMapper.ok(result);
    }

    @PostMapping(value = "/add")
    public Wrapper add(@RequestBody BusinessCardDto businessCardDto) {
        try {
            businessCardService.add(businessCardDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessCardEditDto businessCardEditDto) {
        try {
            businessCardService.update(id, businessCardEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessCardService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

}
