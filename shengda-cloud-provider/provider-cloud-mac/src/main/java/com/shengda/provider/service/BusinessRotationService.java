package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessRotationDto;
import com.shengda.dto.BusinessRotationEditDto;
import com.shengda.provider.model.domain.BusinessRotation;
import com.shengda.query.BusinessRotationQuery;
import com.shengda.vo.BusinessRotationVo;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessRotationService extends IService<BusinessRotation> {

    /**
     * 分页查询名片轮播
     *
     * @param businessRotationQuery businessRotationQuery
     * @return IPage<BusinessRotationVo>
     */
    IPage<BusinessRotationVo> list(BusinessRotationQuery businessRotationQuery);

    /**
     * 新增名片轮播
     *
     * @param businessRotationDto businessRotationDto
     */
    void add(BusinessRotationDto businessRotationDto);

    /**
     * 修改名片轮播
     *
     * @param id                      id
     * @param businessRotationEditDto businessRotationEditDto
     */
    void update(Long id, BusinessRotationEditDto businessRotationEditDto);

    /**
     * 删除名片轮播
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 根据卡片id查询轮播图
     *
     * @param cardId cardId
     * @return List<BusinessRotationVo>
     */
    List<BusinessRotationVo> getByCardId(Long cardId);
}
