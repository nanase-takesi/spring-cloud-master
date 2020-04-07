package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BusinessVideoDto;
import com.shengda.dto.BusinessVideoEditDto;
import com.shengda.exception.MacBizException;
import com.shengda.provider.mapper.BusinessVideoMapper;
import com.shengda.provider.model.domain.BusinessVideo;
import com.shengda.provider.service.BusinessVideoService;
import com.shengda.query.BusinessVideoQuery;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BusinessVideoVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.shengda.enums.MacErrorCodeEnum.MAC100600081;
import static com.shengda.enums.MacErrorCodeEnum.MAC100600082;
import static com.shengda.provider.model.enums.BusinessVideoState.INVALID;
import static com.shengda.provider.model.enums.BusinessVideoState.IN_USE;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessVideoServiceImpl extends ServiceImpl<BusinessVideoMapper, BusinessVideo> implements BusinessVideoService {

    private final BusinessVideoMapper businessVideoMapper;

    @Override
    public IPage<BusinessVideoVo> list(BusinessVideoQuery businessVideoQuery) {
        IPage<BusinessVideoVo> page = new Page<>(businessVideoQuery.getCurrent(), businessVideoQuery.getPageSize());
        return businessVideoMapper.queryPage(page, businessVideoQuery);
    }

    @Override
    public void add(BusinessVideoDto businessVideoDto) {
        BusinessVideo businessVideo = new BusinessVideo();
        CachedBeanCopierUtils.copy(businessVideoDto, businessVideo);
        businessVideo.setState(IN_USE.getValue());
        int flag = businessVideoMapper.insert(businessVideo);

        if (flag <= 0) {
            throw new MacBizException(MAC100600081);
        }
    }

    @Override
    public void update(Long id, BusinessVideoEditDto businessVideoEditDto) {
        BusinessVideo businessVideo = businessVideoMapper.selectById(id);

        if (!Objects.isNull(businessVideo)) {
            CachedBeanCopierUtils.copy(businessVideoEditDto, businessVideo);
            businessVideoMapper.updateById(businessVideo);
        } else {
            throw new MacBizException(MAC100600082);
        }
    }

    @Override
    public void delete(Long id) {
        BusinessVideo businessVideo = businessVideoMapper.selectById(id);

        if (!Objects.isNull(businessVideo)) {
            businessVideo.setState(INVALID.getValue());
            businessVideoMapper.updateById(businessVideo);
        } else {
            throw new MacBizException(MAC100600082);
        }
    }

    @Override
    public List<BusinessVideoVo> queryByCardId(Long cardId, BusinessVideoQuery businessVideoQuery) {
        IPage<BusinessVideoVo> page = new Page<>(businessVideoQuery.getCurrent(), businessVideoQuery.getPageSize());
        return businessVideoMapper.queryPageByCardId(page, cardId, businessVideoQuery);
    }
}
