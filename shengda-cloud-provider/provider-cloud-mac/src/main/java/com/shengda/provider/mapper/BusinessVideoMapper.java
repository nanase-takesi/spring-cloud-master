package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessVideo;
import com.shengda.query.BusinessVideoQuery;
import com.shengda.vo.BusinessVideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessVideoMapper extends BaseMapper<BusinessVideo> {

    /**
     * 分页查询视频
     *
     * @param page               page
     * @param businessVideoQuery businessVideoQuery
     * @return IPage<BusinessVideodVo>
     */
    IPage<BusinessVideoVo> queryPage(IPage<BusinessVideoVo> page, @Param("query") BusinessVideoQuery businessVideoQuery);

    /**
     * 查询视频
     *
     * @param page               page
     * @param cardId             cardId
     * @param businessVideoQuery businessVideoQuery
     * @return List<BusinessVideoVo>
     */
    List<BusinessVideoVo> queryPageByCardId(IPage<BusinessVideoVo> page, @Param("cardId") Long cardId,
                                            @Param("query") BusinessVideoQuery businessVideoQuery);
}
