package com.shengda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author takesi
 * @date 2020-03-19
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderCloudUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCloudUacApplication.class, args);
    }

}
