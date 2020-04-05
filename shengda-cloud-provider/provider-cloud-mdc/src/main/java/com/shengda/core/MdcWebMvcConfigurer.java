package com.shengda.core;

import com.shengda.core.constant.MdcConstant;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Configuration
public class MdcWebMvcConfigurer implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(MdcWebMvcConfigurer.class);

    @Resource
    public MinioClient minioClient(MinioClient minioClient) {
        try {
            if (!minioClient.bucketExists(MdcConstant.BUCK_NAME)) {
                minioClient.makeBucket(MdcConstant.BUCK_NAME);
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return minioClient;
    }

}
