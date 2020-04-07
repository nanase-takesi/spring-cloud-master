package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.BusinessArticle;
import com.shengda.query.BusinessArticleQuery;
import com.shengda.vo.BusinessArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Mapper
public interface BusinessArticleMapper extends BaseMapper<BusinessArticle> {

    /**
     * 分页查询文章
     *
     * @param page                 page
     * @param businessArticleQuery businessArticleQuery
     * @return IPage<BusinessArticleVo>
     */
    IPage<BusinessArticleVo> queryPage(IPage<BusinessArticleVo> page, @Param("query") BusinessArticleQuery businessArticleQuery);

    /**
     * 查询文章
     *
     * @param page                 page
     * @param cardId               cardId
     * @param businessArticleQuery businessArticleQuery
     * @return IPage<BusinessArticleVo>
     */
    IPage<BusinessArticleVo> queryPageByCardId(IPage<BusinessArticleVo> page, @Param("cardId") Long cardId,
                                               @Param("query") BusinessArticleQuery businessArticleQuery);
}
