package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.RotationDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.model.enums.RotationState;
import com.shengda.provider.service.RotationService;
import com.shengda.query.RotationQuery;
import com.shengda.vo.RotationVo;
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
 * @date 2019-12-26
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/rotation")
public class RotationController extends BaseController {

    private final RotationService rotationService;

    @GetMapping(value = "/list")
    public PageWrapper<List<RotationVo>> queryList(RotationQuery rotationQuery) {
        IPage<RotationVo> result = rotationService.list(rotationQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/add")
    public Wrapper<String> add(@RequestBody RotationDto rotationDto) {
        try {
            rotationService.add(rotationDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper<String> update(@PathVariable("id") Long id, @RequestBody RotationDto rotationDto) {
        try {
            rotationService.update(id, rotationDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper<String> delete(@PathVariable("id") Long id) {
        try {
            rotationService.changeState(id, RotationState.INVALID);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PatchMapping(value = "/{id}/un_delete")
    public Wrapper<String> unDelete(@PathVariable Long id) {
        try {
            rotationService.changeState(id, RotationState.IN_USE);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/batch_delete")
    public Wrapper<String> batchDelete(@RequestBody List<Long> ids) {
        try {
            rotationService.batchDelete(ids);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

}
