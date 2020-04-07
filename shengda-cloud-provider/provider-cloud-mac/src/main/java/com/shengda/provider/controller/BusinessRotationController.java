package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessRotationDto;
import com.shengda.dto.BusinessRotationEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessRotationService;
import com.shengda.query.BusinessRotationQuery;
import com.shengda.vo.BusinessRotationVo;
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
@RequestMapping(value = "/business")
public class BusinessRotationController extends BaseController {

    private final BusinessRotationService businessRotationService;

    @GetMapping(value = "/rotation/list")
    public PageWrapper list(BusinessRotationQuery businessRotationQuery) {
        IPage<BusinessRotationVo> result = businessRotationService.list(businessRotationQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/rotation/add")
    public Wrapper add(@RequestBody BusinessRotationDto businessRotationDto) {
        try {
            businessRotationService.add(businessRotationDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/rotation/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessRotationEditDto businessRotationEditDto) {
        try {
            businessRotationService.update(id, businessRotationEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/rotation/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessRotationService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @GetMapping(value = "/{cardId}/rotation/list")
    public Wrapper list(@PathVariable("cardId") Long cardId) {
        List<BusinessRotationVo> result = businessRotationService.getByCardId(cardId);
        return WrapMapper.ok(result);
    }

}
