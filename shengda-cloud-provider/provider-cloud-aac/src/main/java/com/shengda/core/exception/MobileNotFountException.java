package com.shengda.core.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author takesi
 * @date 2020-03-27
 */
public class MobileNotFountException extends UsernameNotFoundException {

    private static final long serialVersionUID = -7586256912617564880L;

    public MobileNotFountException(String msg) {
        super(msg);
    }

}
