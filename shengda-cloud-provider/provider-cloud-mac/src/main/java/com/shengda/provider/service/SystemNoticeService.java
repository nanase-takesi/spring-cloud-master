package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.SystemNoticeDto;
import com.shengda.provider.model.domain.SystemNotice;
import com.shengda.provider.model.enums.SystemNoticeState;
import com.shengda.query.SystemNoticeQuery;
import com.shengda.vo.SystemNoticeVo;

/**
 * @author takesi
 * @date 2019-12-25
 */
public interface SystemNoticeService extends IService<SystemNotice> {

    /**
     * 新增系统公告
     *
     * @param systemNoticeDto systemNoticeDto
     */
    void insert(SystemNoticeDto systemNoticeDto);

    /**
     * 分页查询
     *
     * @param systemNoticeQuery systemNoticeQuery
     * @return systemNoticeQuery
     */
    IPage<SystemNoticeVo> list(SystemNoticeQuery systemNoticeQuery);

    /**
     * 修改系统公告状态
     *
     * @param id    id
     * @param state state
     */
    void changeState(Long id, SystemNoticeState state);

    /**
     * 编辑系统公告
     *
     * @param id              id
     * @param systemNoticeDto systemNoticeDto
     */
    void update(long id, SystemNoticeDto systemNoticeDto);
}
