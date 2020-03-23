package com.shengda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author takesi
 * @date 2020-03-19
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderCloudMdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCloudMdcApplication.class, args);
    }

}
