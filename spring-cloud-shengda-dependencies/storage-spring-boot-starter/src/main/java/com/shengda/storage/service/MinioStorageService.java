package com.shengda.storage.service;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.MinioException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;
import io.minio.messages.Bucket;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author takesi
 * @date 2020-03-17
 */
public interface MinioStorageService {

    /**
     * 上传文件
     *
     * @param bucket      bucket
     * @param inputStream inputStream
     * @param fileName    fileName
     * @param size        size
     * @return 上传成功后返回生成的文件id；失败，返回null
     */
    String upload(String bucket, InputStream inputStream, Long size, String fileName);

    /**
     * 上传文件
     *
     * @param bucket      bucket
     * @param inputStream inputStream
     * @param fileName    fileName
     * @param size        size
     * @param contentType contentType
     * @return 上传成功后返回生成的文件id；失败，返回null
     */
    String upload(String bucket, InputStream inputStream, Long size, String fileName, String contentType);

    /**
     * 生成一个给HTTP PUT请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行上传，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
     *
     * @param bucket   bucket
     * @param fileName fileName
     * @param expiry   失效时间(以秒为单位), 默认是7天，不得大于7天
     * @return url
     */
    String presignedUpload(String bucket, String fileName, Integer expiry);

    /**
     * 生成一个给HTTP GET请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行下载，即使其所在的存储桶是私有的。
     *
     * @param bucket     bucket
     * @param objectName objectName
     * @return Sting
     */
    String presignedGetObject(String bucket, String objectName);

    /**
     * 生成一个给HTTP GET请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行下载，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
     *
     * @param bucket     bucket
     * @param objectName objectName
     * @param expires    expires
     * @return Sting
     */
    String presignedGetObject(String bucket, String objectName, Integer expires);

    /**
     * 创建存储桶
     *
     * @param bucketName bucketName
     * @throws IOException              IOException
     * @throws InvalidKeyException      InvalidKeyException
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws MinioException           MinioException
     * @throws XmlPullParserException   XmlPullParserException
     */
    void makeBucket(String bucketName) throws IOException, InvalidKeyException, NoSuchAlgorithmException, MinioException
            , XmlPullParserException;

    /**
     * 创建存储桶
     *
     * @param bucketName bucketName
     * @param region     region
     * @throws IOException              IOException
     * @throws InvalidKeyException      InvalidKeyException
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws MinioException           MinioException
     * @throws XmlPullParserException   XmlPullParserException
     */
    void makeBucket(String bucketName, String region) throws IOException, InvalidKeyException, NoSuchAlgorithmException, MinioException, XmlPullParserException;

    /**
     * 列出所有存储桶
     *
     * @return List<Bucket>
     * @throws IOException                IOException
     * @throws InvalidKeyException        InvalidKeyException
     * @throws NoSuchAlgorithmException   NoSuchAlgorithmException
     * @throws InsufficientDataException  InsufficientDataException
     * @throws InvalidResponseException   InvalidResponseException
     * @throws InternalException          InternalException
     * @throws NoResponseException        NoResponseException
     * @throws InvalidBucketNameException InvalidBucketNameException
     * @throws XmlPullParserException     XmlPullParserException
     * @throws ErrorResponseException     ErrorResponseException
     */
    List<Bucket> listBucket() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException;

    /**
     * 删除bucket
     *
     * @param bucket bucket
     * @throws IOException                IOException
     * @throws InvalidKeyException        InvalidKeyException
     * @throws NoSuchAlgorithmException   NoSuchAlgorithmException
     * @throws InsufficientDataException  InsufficientDataException
     * @throws InvalidResponseException   InvalidResponseException
     * @throws InternalException          InternalException
     * @throws NoResponseException        NoResponseException
     * @throws InvalidBucketNameException InvalidBucketNameException
     * @throws XmlPullParserException     XmlPullParserException
     * @throws ErrorResponseException     ErrorResponseException
     */
    void deleteBucket(String bucket) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException;

}
