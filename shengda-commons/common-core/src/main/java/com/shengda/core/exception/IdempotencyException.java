package com.shengda.core.exception;

/**
 * 幂等性异常
 *
 * @author takesi
 * @date 2020-03-02
 */
public class IdempotencyException extends RuntimeException {

    private static final long serialVersionUID = -3141635086361287208L;

    public IdempotencyException(String message) {
        super(message);
    }
}
