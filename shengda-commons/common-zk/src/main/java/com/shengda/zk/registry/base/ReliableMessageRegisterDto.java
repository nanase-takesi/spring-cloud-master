package com.shengda.zk.registry.base;

import com.google.common.base.Preconditions;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Getter
public class ReliableMessageRegisterDto implements Serializable {

    private static final long serialVersionUID = 2647541305382773476L;

    private String consumerGroup;

    private String producerGroup;

    private String namesrvAddr;

    /**
     * Sets consumer group.
     *
     * @param consumerGroup the consumer group
     * @return the consumer group
     */
    public ReliableMessageRegisterDto setConsumerGroup(final String consumerGroup) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(consumerGroup), "init zk cid is null");
        this.consumerGroup = consumerGroup;
        return this;
    }

    /**
     * Sets producer group.
     *
     * @param producerGroup the producer group
     * @return the producer group
     */
    public ReliableMessageRegisterDto setProducerGroup(final String producerGroup) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(producerGroup), "init zk pid is null");
        this.producerGroup = producerGroup;
        return this;
    }

    /**
     * Sets namesrv addr.
     *
     * @param namesrvAddr the namesrv addr
     * @return the namesrv addr
     */
    public ReliableMessageRegisterDto setNamesrvAddr(final String namesrvAddr) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(namesrvAddr), "init ZK namesrvAddr is null");
        this.namesrvAddr = namesrvAddr;
        return this;
    }

}
