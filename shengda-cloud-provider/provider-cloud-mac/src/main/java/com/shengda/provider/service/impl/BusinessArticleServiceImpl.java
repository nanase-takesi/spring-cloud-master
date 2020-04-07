package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessArticleDto;
import com.shengda.dto.BusinessArticleEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessArticleMapper;
import com.shengda.provider.model.domain.BusinessArticle;
import com.shengda.provider.service.BusinessArticleService;
import com.shengda.query.BusinessArticleQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessArticleVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600071;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600072;
import static com.shengda.provider.model.enums.BusinessArticleState.INVALID;
import static com.shengda.provider.model.enums.BusinessArticleState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessArticleServiceImpl extends ServiceImpl<BusinessArticleMapper, BusinessArticle> implements BusinessArticleService {

    private final BusinessArticleMapper businessArticleMapper;

    @Override
    public IPage<BusinessArticleVo> list(BusinessArticleQuery businessArticleQuery) {
        IPage<BusinessArticleVo> page = new Page<>(businessArticleQuery.getCurrent(),
                businessArticleQuery.getPageSize());
        return businessArticleMapper.queryPage(page, businessArticleQuery);
    }

    @Override
    public void add(BusinessArticleDto businessArticleDto) {
        BusinessArticle businessArticle = new BusinessArticle();
        CachedBeanCopierUtils.copy(businessArticleDto, businessArticle);
        businessArticle.setState(IN_USE.getValue());
        int flag = businessArticleMapper.insert(businessArticle);

        if (flag <= 0) {
            throw new MacBizException(MAC100600071);
        }
    }

    @Override
    public void update(Long id, BusinessArticleEditDto businessArticleEditDto) {
        BusinessArticle businessArticle = businessArticleMapper.selectById(id);

        if (!Objects.isNull(businessArticle)) {
            CachedBeanCopierUtils.copy(businessArticleEditDto, businessArticle);
            businessArticleMapper.updateById(businessArticle);
        } else {
            throw new MacBizException(MAC100600072);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessArticle businessArticle = businessArticleMapper.selectById(id);

        if (!Objects.isNull(businessArticle)) {
            businessArticle.setState(INVALID.getValue());
            businessArticleMapper.updateById(businessArticle);
        } else {
            throw new MacBizException(MAC100600072);
        }
    }

    @Override
    public IPage<BusinessArticleVo> list(Long cardId, BusinessArticleQuery businessArticleQuery) {
        IPage<BusinessArticleVo> page = new Page<>(businessArticleQuery.getCurrent(),
                businessArticleQuery.getPageSize());
        return businessArticleMapper.queryPageByCardId(page, cardId, businessArticleQuery);
    }
}
