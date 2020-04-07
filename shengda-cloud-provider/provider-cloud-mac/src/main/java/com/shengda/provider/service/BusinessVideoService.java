package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessVideoDto;
import com.shengda.dto.BusinessVideoEditDto;
import com.shengda.provider.model.domain.BusinessVideo;
import com.shengda.query.BusinessVideoQuery;
import com.shengda.vo.BusinessVideoVo;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessVideoService extends IService<BusinessVideo> {

    /**
     * 分页查新视频
     *
     * @param businessVideoQuery businessVideoQuery
     * @return IPage<BusinessVideodVo>
     */
    IPage<BusinessVideoVo> list(BusinessVideoQuery businessVideoQuery);

    /**
     * 添加视频
     *
     * @param businessVideoDto businessVideoDto
     */
    void add(BusinessVideoDto businessVideoDto);

    /**
     * 更新视频
     *
     * @param id                   id
     * @param businessVideoEditDto businessVideoEditDto
     */
    void update(Long id, BusinessVideoEditDto businessVideoEditDto);

    /**
     * 删除视频
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 查询视频
     *
     * @param cardId cardId
     * @param businessVideoQuery businessVideoQuery
     * @return List<BusinessVideoVo>
     */
    List<BusinessVideoVo> queryByCardId(Long cardId, BusinessVideoQuery businessVideoQuery);
}
