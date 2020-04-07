package com.shengda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author takesi
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderCloudMacApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCloudMacApplication.class, args);
    }

}
