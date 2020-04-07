package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.SystemNoticeDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.model.enums.SystemNoticeState;
import com.shengda.provider.service.SystemNoticeService;
import com.shengda.query.SystemNoticeQuery;
import com.shengda.vo.SystemNoticeVo;
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
 * @date 2019-12-25
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/system/notice")
public class SystemNoticeController extends BaseController {

    private final SystemNoticeService systemNoticeService;

    @PostMapping(value = "/add")
    public Wrapper<String> add(@RequestBody SystemNoticeDto systemNoticeDto) {
        try {
            systemNoticeService.insert(systemNoticeDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @GetMapping(value = "/list")
    public PageWrapper<List<SystemNoticeVo>> list(SystemNoticeQuery systemNoticeQuery) {
        IPage<SystemNoticeVo> result = systemNoticeService.list(systemNoticeQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper<String> delete(@PathVariable("id") Long id) {
        try {
            systemNoticeService.changeState(id, SystemNoticeState.INVALID);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PatchMapping(value = "/{id}/un_delete")
    public Wrapper<String> unDelete(@PathVariable Long id) {
        try {
            systemNoticeService.changeState(id, SystemNoticeState.IN_USE);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper<String> update(@PathVariable("id") Long id, @RequestBody SystemNoticeDto systemNoticeDto) {
        try {
            systemNoticeService.update(id, systemNoticeDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

}
