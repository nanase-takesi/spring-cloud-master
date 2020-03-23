package com.shengda.base.enums;

/**
 * @author takesi
 * @date 2019-12-28
 */
public interface ErrorCodeEnum {

    /**
     * 状态码
     *
     * @return int
     */
    int code();

    /**
     * 信息
     *
     * @return String
     */
    String msg();

    /**
     * getInstance
     *
     * @param code code
     * @return ErrorCodeEnum
     */
    ErrorCodeEnum getInstance(int code);

}
