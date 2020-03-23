package com.shengda.redis.constant;

/**
 * redis 工具常量
 *
 * @author takesi
 * @date 2020-03-01
 */
public final class RedisToolsConstant {

    private RedisToolsConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * single Redis
     */
    public final static int SINGLE = 1;

    /**
     * Redis cluster
     */
    public final static int CLUSTER = 2;

}
