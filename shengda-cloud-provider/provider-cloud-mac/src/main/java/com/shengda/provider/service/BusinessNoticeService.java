package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessNoticeDto;
import com.shengda.dto.BusinessNoticeEditDto;
import com.shengda.provider.model.domain.BusinessNotice;
import com.shengda.query.BusinessNoticeQuery;
import com.shengda.vo.BusinessNoticeVo;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessNoticeService extends IService<BusinessNotice> {

    /**
     * 分页查询公告信息
     *
     * @param businessNoticeQuery businessNoticeQuery
     * @return IPage<BusinessNoticeVo>
     */
    IPage<BusinessNoticeVo> list(BusinessNoticeQuery businessNoticeQuery);

    /**
     * 新增公告
     *
     * @param businessNoticeDto businessNoticeDto
     */
    void add(BusinessNoticeDto businessNoticeDto);

    /**
     * 编辑公告
     *
     * @param id                    id
     * @param businessNoticeEditDto businessNoticeEditDto
     */
    void update(Long id, BusinessNoticeEditDto businessNoticeEditDto);

    /**
     * 删除公告
     *
     * @param id id
     */
    void delete(Long id);
}
