package com.shengda.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 *
 * @author takesi
 * @date 2020-03-28
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 150592123707351844L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
