package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.ReferralDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.model.enums.ReferralState;
import com.shengda.provider.service.ReferralService;
import com.shengda.query.ReferralQuery;
import com.shengda.vo.ReferralVo;
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
@RequestMapping(value = "/referral")
public class ReferralController extends BaseController {

    private final ReferralService referralService;

    @GetMapping(value = "/list")
    public PageWrapper<List<ReferralVo>> list(ReferralQuery referralQuery) {
        IPage<ReferralVo> result = referralService.list(referralQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/add")
    public Wrapper<String> add(@RequestBody ReferralDto referralDto) {
        try {
            referralService.add(referralDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}/update")
    public Wrapper<String> update(@PathVariable("id") Long id, @RequestBody ReferralDto referralDto) {
        try {
            referralService.update(id, referralDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper<String> delete(@PathVariable("id") Long id) {
        try {
            referralService.changeState(id, ReferralState.INVALID);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PatchMapping(value = "/{id}/un_delete")
    public Wrapper<String> unDelete(@PathVariable Long id) {
        try {
            referralService.changeState(id, ReferralState.IN_USE);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

}
