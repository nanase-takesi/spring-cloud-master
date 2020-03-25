package com.shengda.zk.registry.exception;

/**
 * 注册中心异常.
 *
 * @author takesi
 * @date 2020-03-25
 */
public class RegException extends RuntimeException {

    private static final long serialVersionUID = -3554771103705917484L;

    /**
     * Instantiates a new Reg exception.
     *
     * @param errorMessage the error message
     * @param args         the args
     */
    public RegException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    /**
     * Instantiates a new Reg exception.
     *
     * @param cause the cause
     */
    public RegException(final Exception cause) {
        super(cause);
    }

}
