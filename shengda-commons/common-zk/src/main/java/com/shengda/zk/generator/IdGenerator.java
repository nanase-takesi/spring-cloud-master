package com.shengda.zk.generator;

/**
 * @author takesi
 * @date 2020-03-25
 */
public interface IdGenerator {

    /**
     * 生成下一个ID
     *
     * @return the string
     */
    Long nextId();

}
