package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessNotice;
import com.shengda.query.BusinessNoticeQuery;
import com.shengda.vo.BusinessNoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessNoticeMapper extends BaseMapper<BusinessNotice> {

    /**
     * 分页查询公告
     *
     * @param page                page
     * @param businessNoticeQuery businessNoticeQuery
     * @return IPage<BusinessNoticeVo>
     */
    IPage<BusinessNoticeVo> queryPage(IPage<BusinessNoticeVo> page, @Param("query") BusinessNoticeQuery businessNoticeQuery);
}
