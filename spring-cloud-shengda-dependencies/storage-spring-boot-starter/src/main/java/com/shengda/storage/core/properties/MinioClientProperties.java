package com.shengda.storage.core.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-17
 */
@Getter
@ConfigurationProperties(prefix = "spring.storage.minio")
public class MinioClientProperties implements Serializable {

    private static final long serialVersionUID = -4440114916295668280L;

    private String endpoint;

    private String accessKey;

    private String secretKey;

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
