package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessGridDto;
import com.shengda.dto.BusinessGridEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessGridService;
import com.shengda.query.BusinessGridQuery;
import com.shengda.vo.BusinessGridVo;
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
public class BusinessGridController extends BaseController {

    private final BusinessGridService businessGridService;

    @GetMapping(value = "/grid/list")
    public PageWrapper list(BusinessGridQuery businessGridQuery) {
        IPage<BusinessGridVo> result = businessGridService.list(businessGridQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/grid/add")
    public Wrapper add(@RequestBody BusinessGridDto businessGridDto) {
        try {
            businessGridService.add(businessGridDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/grid/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessGridEditDto businessGridEditDto) {
        try {
            businessGridService.update(id, businessGridEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/grid/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessGridService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @GetMapping(value = "/{cardId}/grid/list")
    public Wrapper list(@PathVariable("cardId") Long cardId) {
        List<BusinessGridVo> result = businessGridService.queryByCardId(cardId);
        return WrapMapper.ok(result);
    }

}
