package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessCardDto;
import com.shengda.dto.BusinessCardEditDto;
import com.shengda.provider.model.domain.BusinessCard;
import com.shengda.query.BusinessCardQuery;
import com.shengda.vo.BusinessCardVo;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessCardService extends IService<BusinessCard> {

    /**
     * 分页查询名片
     *
     * @param businessCardQuery businessCardQuery
     * @return IPage<BusinessCardVo>
     */
    IPage<BusinessCardVo> list(BusinessCardQuery businessCardQuery);

    /**
     * 查询全部名片信息
     *
     * @param name name
     * @return List<BusinessCardVo>
     */
    List<BusinessCardVo> list(String name);

    /**
     * 添加名片
     *
     * @param businessCardDto businessCardDto
     */
    void add(BusinessCardDto businessCardDto);

    /**
     * 更新名片
     *
     * @param id                  id
     * @param businessCardEditDto businessCardEditDto
     */
    void update(Long id, BusinessCardEditDto businessCardEditDto);

    /**
     * 删除名片
     *
     * @param id id
     */
    void delete(Long id);
}
