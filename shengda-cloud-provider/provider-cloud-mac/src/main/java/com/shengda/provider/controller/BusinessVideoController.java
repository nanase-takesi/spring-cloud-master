package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessVideoDto;
import com.shengda.dto.BusinessVideoEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessVideoService;
import com.shengda.query.BusinessVideoQuery;
import com.shengda.vo.BusinessVideoVo;
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
 * @date 2019-12-27
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/business")
public class BusinessVideoController extends BaseController {

    private final BusinessVideoService businessVideoService;

    @GetMapping(value = "/video/list")
    public PageWrapper list(BusinessVideoQuery businessVideoQuery) {
        IPage<BusinessVideoVo> result = businessVideoService.list(businessVideoQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/video/add")
    public Wrapper add(@RequestBody BusinessVideoDto businessVideoDto) {
        try {
            businessVideoService.add(businessVideoDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/video/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessVideoEditDto businessVideoEditDto) {
        try {
            businessVideoService.update(id, businessVideoEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/video/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessVideoService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @GetMapping(value = "/{cardId}/video/list")
    public Wrapper list(@PathVariable("cardId") Long cardId, BusinessVideoQuery businessVideoQuery) {
        List<BusinessVideoVo> result = businessVideoService.queryByCardId(cardId, businessVideoQuery);
        return WrapMapper.ok(result);
    }

}
