package com.shengda.storage.service;

import com.aliyun.oss.model.Bucket;
import com.shengda.storage.domain.OssCallbackResult;
import com.shengda.storage.domain.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传
 *
 * @author takesi
 * @date 2020-03-17
 */
public interface AliyunOssStorageService {

    /**
     * oss上传策略生成
     *
     * @param bucket   bucket
     * @param fileType fileType
     * @return OssPolicyResult
     */
    OssPolicyResult policy(String bucket, String fileType);

    /**
     * oss上传成功回调
     *
     * @param request request
     * @return OssCallbackResult
     */
    OssCallbackResult callback(HttpServletRequest request);

    /**
     * 创建bucket
     *
     * @param bucket bucket
     * @return Bucket
     */
    Bucket makeBucket(String bucket);

}
