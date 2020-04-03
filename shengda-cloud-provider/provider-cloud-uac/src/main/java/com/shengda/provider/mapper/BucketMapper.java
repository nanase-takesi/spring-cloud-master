package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shengda.provider.model.domain.Bucket;
import com.shengda.query.BucketQuery;
import com.shengda.vo.BucketVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Mapper
public interface BucketMapper extends BaseMapper<Bucket> {

    /**
     * 分页查询bucket
     *
     * @param page        page
     * @param bucketQuery bucketQuery
     * @return IPage<BucketVo>
     */
    IPage<BucketVo> queryBucket(IPage<BucketVo> page, @Param("query") BucketQuery bucketQuery);
}
