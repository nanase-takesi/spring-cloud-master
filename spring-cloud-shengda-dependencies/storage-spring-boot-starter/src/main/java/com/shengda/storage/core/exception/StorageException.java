package com.shengda.storage.core.exception;

/**
 * @author takesi
 * @date 2020-03-26
 */
public class StorageException extends RuntimeException {

    private static final long serialVersionUID = 2028995258665741325L;

    public StorageException() {
    }

    public StorageException(String message) {
        super(message);
    }
}
