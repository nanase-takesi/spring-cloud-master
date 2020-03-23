package com.shengda.redis.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @author takesi
 * @date 2020-03-01
 */
@Getter
@ConfigurationProperties(prefix = "spring.redis.cache")
public class CacheManagerProperties implements Serializable {

    private static final long serialVersionUID = -3699296239613320076L;

    private List<CacheConfig> configs;

    public void setConfigs(List<CacheConfig> configs) {
        this.configs = configs;
    }

    @Data
    public static class CacheConfig {
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间，sec
         */
        private long second = 60;
    }
}
