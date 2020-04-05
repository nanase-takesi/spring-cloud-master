package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.BucketDto;
import com.shengda.enums.UacBizErrorCode;
import com.shengda.exception.UacBizException;
import com.shengda.provider.mapper.BucketMapper;
import com.shengda.provider.model.domain.Bucket;
import com.shengda.provider.service.BucketService;
import com.shengda.query.BucketQuery;
import com.shengda.storage.core.exception.StorageException;
import com.shengda.storage.service.MinioStorageService;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.BucketVo;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Service
@AllArgsConstructor
public class BucketServiceImpl extends ServiceImpl<BucketMapper, Bucket> implements BucketService {

    private static final Logger logger = LoggerFactory.getLogger(BucketServiceImpl.class);

    private final BucketMapper bucketMapper;

    private final MinioStorageService minioStorageService;

    @Override
    public IPage<BucketVo> list(BucketQuery bucketQuery) {
        IPage<BucketVo> page = new Page<>(bucketQuery.getCurrent(), bucketQuery.getPageSize());
        return bucketMapper.queryBucket(page, bucketQuery);
    }

    @Override
    @Transactional(rollbackFor = StorageException.class)
    public void add(BucketDto bucketDto) throws StorageException {
        try {
            QueryWrapper<Bucket> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(Bucket.COL_NAME, bucketDto.getName())
                    .eq(Bucket.COL_TYPE, bucketDto.getType());
            List<Bucket> list = bucketMapper.selectList(queryWrapper);

            if (list.size() == 0) {
                minioStorageService.makeBucket(bucketDto.getName());
                Bucket bucket = CachedBeanCopierUtils.copyBean(bucketDto, Bucket.class);
                bucketMapper.insert(bucket);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new StorageException("创建bucket失败");
        }
    }

    @Override
    @Transactional(rollbackFor = StorageException.class)
    public void delete(Long id) throws StorageException {
        Bucket bucket = bucketMapper.selectById(id);

        if (!Objects.isNull(bucket)) {
            try {
                minioStorageService.deleteBucket(bucket.getName());
                bucketMapper.deleteById(bucket);
            } catch (Exception e) {
                throw new StorageException(e.getMessage());
            }
        } else {
            throw new UacBizException(UacBizErrorCode.RESOURCE_NOT_FOUNT);
        }
    }
}
