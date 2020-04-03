package com.shengda.storage.handler.impl;

import com.shengda.storage.annotation.HandlerStorageType;
import com.shengda.storage.enums.BucketType;
import com.shengda.storage.handler.AbstractStorageHandler;
import com.shengda.storage.service.AliyunOssStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 * @date 2020-03-28
 */
@Component
@AllArgsConstructor
@HandlerStorageType(value = BucketType.ALIYUN_OSS)
public class AliyunOssStorageHandler extends AbstractStorageHandler {

    private final AliyunOssStorageService aliyunOssStorageService;

    @Override
    public void handlerCreateBucket(String bucketName) throws Exception {
        //TODO 待实现阿里云存储创建bucket
    }
}
