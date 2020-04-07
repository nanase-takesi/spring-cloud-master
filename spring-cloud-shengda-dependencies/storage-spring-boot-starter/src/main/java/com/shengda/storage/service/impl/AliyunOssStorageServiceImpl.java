package com.shengda.storage.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.shengda.storage.core.properties.AliyunOssProperties;
import com.shengda.storage.domain.OssCallbackResult;
import com.shengda.storage.domain.OssPolicyResult;
import com.shengda.storage.service.AliyunOssStorageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author takesi
 * @date 2020-03-20
 */
@Component
@AllArgsConstructor
public class AliyunOssStorageServiceImpl implements AliyunOssStorageService {

    private static final Logger logger = LoggerFactory.getLogger(AliyunOssStorageServiceImpl.class);

    @Autowired(required = false)
    private OSS ossClient;

    private final AliyunOssProperties aliyunOssProperties;

    @Override
    public OssPolicyResult policy(final String bucket, final String fileType) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dir = sdf.format(new Date());
        String host = "http://" + bucket + "." + aliyunOssProperties.getEndpoint() + "/";
        long expireTime = 30L;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConditions = new PolicyConditions();
        policyConditions.addConditionItem(
                PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConditions.addConditionItem(MatchMode.StartWith,
                PolicyConditions.COND_KEY, dir + '/');

        String postPolicy = ossClient.generatePostPolicy(expiration,
                policyConditions);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        OssPolicyResult result = new OssPolicyResult();
        result.setAccessKeyId(aliyunOssProperties.getAccessKeyId());
        result.setPolicy(encodedPolicy);
        result.setSignature(postSignature);
        result.setDir(dir + "/");
        result.setHost(host);
        result.setExpire(String.valueOf(expireEndTime / 1000));
        result.setKey(dir + "/" + System.currentTimeMillis() + fileType);
        return null;
    }

    @Override
    public OssCallbackResult callback(HttpServletRequest request) {
        return null;
    }

    @Override
    public Bucket makeBucket(@NonNull String bucket) {
        return ossClient.createBucket(bucket);
    }
}
