package com.shengda.zk.properties;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Getter
public class ZookeeperProperties implements Serializable {

    private static final long serialVersionUID = -1365711001206279547L;

    /**
     * 连接Zookeeper服务器的列表
     * 包括IP地址和端口号
     * 多个地址用逗号分隔
     * 如: host1:2181,host2:2181
     */
    private String zkAddressList;

    /**
     * Zookeeper的命名空间
     */
    private String namespace;

    /**
     * 等待重试的间隔时间的初始值
     * 单位：毫秒
     */
    private int baseSleepTimeMilliseconds = 1000;

    /**
     * 等待重试的间隔时间的最大值
     * 单位：毫秒
     */
    private int maxSleepTimeMilliseconds = 3000;

    /**
     * 最大重试次数
     */
    private int maxRetries = 3;

    /**
     * 连接超时时间
     * 单位：毫秒
     */
    private int connectionTimeoutMilliseconds = 15000;

    /**
     * 会话超时时间
     * 单位：毫秒
     */
    private int sessionTimeoutMilliseconds = 60000;

    /**
     * 连接Zookeeper的权限令牌
     * 缺省为不需要权限验
     */
    private String digest;

    public void setZkAddressList(String zkAddressList) {
        this.zkAddressList = zkAddressList;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setBaseSleepTimeMilliseconds(int baseSleepTimeMilliseconds) {
        this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
    }

    public void setMaxSleepTimeMilliseconds(int maxSleepTimeMilliseconds) {
        this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void setConnectionTimeoutMilliseconds(int connectionTimeoutMilliseconds) {
        this.connectionTimeoutMilliseconds = connectionTimeoutMilliseconds;
    }

    public void setSessionTimeoutMilliseconds(int sessionTimeoutMilliseconds) {
        this.sessionTimeoutMilliseconds = sessionTimeoutMilliseconds;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
