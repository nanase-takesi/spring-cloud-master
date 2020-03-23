package com.shengda.core.exception;

/**
 * 分布式锁异常
 *
 * @author takesi
 * @date 2020-03-02
 */
public class LockException extends RuntimeException {

    private static final long serialVersionUID = -6031038024087065064L;

    public LockException(String message) {
        super(message);
    }
}
