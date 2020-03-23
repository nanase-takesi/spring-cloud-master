package com.shengda.storage.core.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-17
 */
@Getter
@ConfigurationProperties(prefix = "spring.storage.oss")
public class AliyunOssProperties implements Serializable {

    private static final long serialVersionUID = 3484138610312781886L;

    private String endpoint;

    private Long maxSize;

    private Long expire;

    private String accessKeyId;

    private String accessKeySecret;

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
