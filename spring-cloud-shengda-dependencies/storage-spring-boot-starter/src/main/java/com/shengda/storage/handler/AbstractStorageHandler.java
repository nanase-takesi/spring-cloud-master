package com.shengda.storage.handler;

/**
 * @author takesi
 * @date 2020-03-26
 */
public abstract class AbstractStorageHandler {

    /**
     * handler
     *
     * @param bucketName bucketName
     * @return String
     * @throws Exception Exception
     */
    abstract public void handlerCreateBucket(String bucketName) throws Exception;

}
