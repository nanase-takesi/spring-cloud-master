package com.shengda.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.dto.BucketDto;
import com.shengda.provider.model.domain.Bucket;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.query.BucketQuery;
import com.shengda.storage.core.exception.StorageException;
import com.shengda.vo.BucketVo;

/**
 * @author takesi
 * @date 2020-03-26
 */
public interface BucketService extends IService<Bucket> {

    /**
     * 分页查询bucket
     *
     * @param bucketQuery bucketQuery
     * @return IPage<BucketVo>
     */
    IPage<BucketVo> list(BucketQuery bucketQuery);

    /**
     * 添加bucket
     *
     * @param bucketDto bucketDto
     * @throws StorageException StorageException
     */
    void add(BucketDto bucketDto) throws StorageException;
}
