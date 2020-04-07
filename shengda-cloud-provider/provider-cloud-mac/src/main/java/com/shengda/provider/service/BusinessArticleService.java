package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.dto.BusinessArticleDto;
import com.shengda.dto.BusinessArticleEditDto;
import com.shengda.provider.model.domain.BusinessArticle;
import com.shengda.query.BusinessArticleQuery;
import com.shengda.vo.BusinessArticleVo;

/**
 * @author takesi
 * @date 2019-12-26
 */
public interface BusinessArticleService extends IService<BusinessArticle> {

    /**
     * 分页查询文章
     *
     * @param businessArticleQuery businessArticleQuery
     * @return IPage<BusinessArticleVo>
     */
    IPage<BusinessArticleVo> list(BusinessArticleQuery businessArticleQuery);

    /**
     * 新增文章
     *
     * @param businessArticleDto businessArticleDto
     */
    void add(BusinessArticleDto businessArticleDto);

    /**
     * 更新文章
     *
     * @param id                     id
     * @param businessArticleEditDto businessArticleEditDto
     */
    void update(Long id, BusinessArticleEditDto businessArticleEditDto);

    /**
     * 删除文章
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 查询个人专栏
     *
     * @param cardId               cardId
     * @param businessArticleQuery businessArticleQuery
     * @return IPage<BusinessArticleVo>
     */
    IPage<BusinessArticleVo> list(Long cardId, BusinessArticleQuery businessArticleQuery);
}
