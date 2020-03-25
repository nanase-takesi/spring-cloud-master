package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.PositionDto;
import com.shengda.dto.PositionUpdateDto;
import com.shengda.provider.service.PositionService;
import com.shengda.query.PositionQuery;
import com.shengda.vo.PositionVo;
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
 * @date 2020-03-24
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/position")
public class PositionController extends BaseController {

    private final PositionService positionService;

    @GetMapping(value = "/list")
    public PageWrapper listPosition(PositionQuery positionQuery) {
        IPage<PositionVo> result = positionService.list(positionQuery);
        return PageWrapMapper.wrap(result.getRecords(),
                result.getCurrent(), result.getPages(), result.getTotal());
    }

    @PostMapping(value = "/add")
    public Wrapper addPosition(@RequestBody PositionDto positionDto) {
        positionService.add(positionDto);
        return WrapMapper.ok();
    }

    @PutMapping(value = "/update")
    public Wrapper updatePosition(@RequestBody PositionUpdateDto positionUpdateDto) {
        positionService.update(positionUpdateDto);
        return WrapMapper.ok();
    }

    @GetMapping(value = "/{id}")
    public Wrapper<PositionVo> getPosition(@PathVariable Long id) {
        PositionVo positionVo = positionService.get(id);
        return WrapMapper.ok(positionVo);
    }

    @DeleteMapping(value = "/{id}")
    public Wrapper deletePosition(@PathVariable Long id) {
        positionService.delete(id);
        return WrapMapper.ok();
    }

}
