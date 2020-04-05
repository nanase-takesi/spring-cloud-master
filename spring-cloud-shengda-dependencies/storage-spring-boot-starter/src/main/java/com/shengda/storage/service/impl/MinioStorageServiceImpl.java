package com.shengda.storage.service.impl;

import com.shengda.storage.service.MinioStorageService;
import com.shengda.storage.utils.StorageUtils;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.MinioException;
import io.minio.errors.NoResponseException;
import io.minio.messages.Bucket;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-17
 */
@Component
@AllArgsConstructor
public class MinioStorageServiceImpl implements MinioStorageService {

    private static final Logger logger = LoggerFactory.getLogger(MinioStorageServiceImpl.class);

    private final MinioClient minioClient;

    @Override
    public String upload(String bucket, InputStream inputStream, Long size, String fileName) {
        return this.upload(bucket, inputStream, size, fileName, null);
    }

    @Override
    public String upload(String bucket, InputStream inputStream, Long size, String fileName, String contentType) {
        String objectName = StorageUtils.getFilePath(fileName);
        try {
            minioClient.putObject(bucket, objectName, inputStream, size, null, null, contentType);
            return objectName;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public String presignedUpload(String bucket, String fileName, Integer expiry) {
        final int days = 60 * 60 * 24 * 7;
        if (Objects.isNull(expiry) || expiry > days) {
            expiry = days;
        }
        try {
            return minioClient.presignedPutObject(bucket, "", expiry);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public String presignedGetObject(String bucket, String objectName) {
        try {
            return minioClient.presignedGetObject(bucket, objectName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public String presignedGetObject(String bucket, String objectName, Integer expires) {
        try {
            return minioClient.presignedGetObject(bucket, objectName, expires);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void makeBucket(@NonNull String bucketName) throws IOException, InvalidKeyException, NoSuchAlgorithmException, MinioException, XmlPullParserException {
        this.makeBucket(bucketName, null);
    }

    @Override
    public void makeBucket(String bucketName, String region) throws IOException, InvalidKeyException, NoSuchAlgorithmException, MinioException, XmlPullParserException {
        boolean fount = minioClient.bucketExists(bucketName);
        if (!fount) {
            minioClient.makeBucket(bucketName);
        } else {
            throw new MinioException("bucket is exists");
        }
    }

    @Override
    public List<Bucket> listBucket() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        // 列出所有存储桶
        return minioClient.listBuckets();
    }

    @Override
    public void deleteBucket(String bucket) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        boolean fount = minioClient.bucketExists(bucket);

        if (fount) {
            minioClient.removeBucket(bucket);
        }
    }

}
