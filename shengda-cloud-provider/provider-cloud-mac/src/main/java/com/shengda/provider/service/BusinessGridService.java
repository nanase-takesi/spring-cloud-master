package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessGridDto;
import com.shengda.dto.BusinessGridEditDto;
import com.shengda.provider.model.domain.BusinessGrid;
import com.shengda.query.BusinessGridQuery;
import com.shengda.vo.BusinessGridVo;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessGridService extends IService<BusinessGrid> {

    /**
     * 分页查询名片图标
     *
     * @param businessGridQuery businessGridQuery
     * @return IPage<BusinessGridVo>
     */
    IPage<BusinessGridVo> list(BusinessGridQuery businessGridQuery);

    /**
     * 新增名片图标
     *
     * @param businessGridDto businessGridDto
     */
    void add(BusinessGridDto businessGridDto);

    /**
     * 更新名片图标
     *
     * @param id                  id
     * @param businessGridEditDto businessGridEditDto
     */
    void update(Long id, BusinessGridEditDto businessGridEditDto);

    /**
     * 删除名片图标
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 查询图标
     *
     * @param cardId cardId
     * @return List<BusinessGridVo>
     */
    List<BusinessGridVo> queryByCardId(Long cardId);
}
