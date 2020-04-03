package com.shengda.storage.handler.impl;

import com.shengda.storage.annotation.HandlerStorageType;
import com.shengda.storage.enums.BucketType;
import com.shengda.storage.handler.AbstractStorageHandler;
import com.shengda.storage.service.MinioStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 * @date 2020-03-26
 */
@Component
@AllArgsConstructor
@HandlerStorageType(value = BucketType.MINIO)
public class MinioStorageHandler extends AbstractStorageHandler {

    private final MinioStorageService minioStorageService;

    @Override
    public void handlerCreateBucket(String bucketName) throws Exception {
        minioStorageService.makeBucket(bucketName);
    }

}
