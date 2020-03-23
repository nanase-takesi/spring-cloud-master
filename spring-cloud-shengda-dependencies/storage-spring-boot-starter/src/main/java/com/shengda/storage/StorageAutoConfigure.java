package com.shengda.storage;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.shengda.storage.core.properties.AliyunOssProperties;
import com.shengda.storage.core.properties.MinioClientProperties;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-17
 */
@AllArgsConstructor
@EnableConfigurationProperties({MinioClientProperties.class, AliyunOssProperties.class})
public class StorageAutoConfigure implements CommandLineRunner {

    private final MinioClientProperties minioClientProperties;

    private final AliyunOssProperties aliyunOssProperties;

    @Bean
    @ConditionalOnMissingBean
    public MinioClient minioClient() throws MinioException {
        if (!Objects.isNull(minioClientProperties)) {
            return new MinioClient(minioClientProperties.getEndpoint(),
                    minioClientProperties.getAccessKey(), minioClientProperties.getSecretKey());
        }
        return null;
    }

    @Bean
    @ConditionalOnMissingBean
    public OSS ossClient() {
        if (!Objects.isNull(aliyunOssProperties)) {
            return new OSSClientBuilder()
                    .build(aliyunOssProperties.getEndpoint(), aliyunOssProperties.getAccessKeyId(),
                            aliyunOssProperties.getAccessKeySecret());
        }
        return null;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
