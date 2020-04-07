package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.SystemNotice;
import com.shengda.query.SystemNoticeQuery;
import com.shengda.vo.SystemNoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2019-12-25
 */
@Mapper
public interface SystemNoticeMapper extends BaseMapper<SystemNotice> {

    /**
     * 分页查询
     *
     * @param page              page
     * @param systemNoticeQuery systemNoticeQuery
     * @return IPage<SystemNoticeVo>
     */
    IPage<SystemNoticeVo> queryPage(IPage<SystemNoticeVo> page, @Param("query") SystemNoticeQuery systemNoticeQuery);
}
