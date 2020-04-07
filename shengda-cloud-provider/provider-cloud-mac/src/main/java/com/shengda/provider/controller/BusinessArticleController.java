package com.shengda.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.base.wrapper.PageWrapMapper;
import com.shengda.base.wrapper.PageWrapper;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.BusinessArticleDto;
import com.shengda.dto.BusinessArticleEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.service.BusinessArticleService;
import com.shengda.query.BusinessArticleQuery;
import com.shengda.vo.BusinessArticleVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author takesi
 * @date 2019-12-27
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/business")
public class BusinessArticleController extends BaseController {

    private final BusinessArticleService businessArticleService;

    @GetMapping(value = "/article/list")
    public PageWrapper list(BusinessArticleQuery businessArticleQuery) {
        IPage<BusinessArticleVo> result = businessArticleService.list(businessArticleQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

    @PostMapping(value = "/article/add")
    public Wrapper add(@RequestBody BusinessArticleDto businessArticleDto) {
        try {
            businessArticleService.add(businessArticleDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @PutMapping(value = "/article/{id}/update")
    public Wrapper update(@PathVariable("id") Long id, @RequestBody BusinessArticleEditDto businessArticleEditDto) {
        try {
            businessArticleService.update(id, businessArticleEditDto);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    @DeleteMapping(value = "/article/{id}/delete")
    public Wrapper delete(@PathVariable("id") Long id) {
        try {
            businessArticleService.delete(id);
            return WrapMapper.ok();
        } catch (MacBizException e) {
            return WrapMapper.error();
        }
    }

    @GetMapping(value = "/{cardId}/article/list")
    public PageWrapper list(@PathVariable("cardId") Long cardId, BusinessArticleQuery businessArticleQuery,
                            HttpSession session) {
        session.getAttribute("access_token");
        IPage<BusinessArticleVo> result = businessArticleService.list(cardId, businessArticleQuery);
        return PageWrapMapper.wrap(
                result.getRecords(),
                result.getCurrent(),
                result.getSize(),
                result.getTotal()
        );
    }

}
