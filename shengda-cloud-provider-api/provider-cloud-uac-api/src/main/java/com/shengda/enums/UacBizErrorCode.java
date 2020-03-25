package com.shengda.enums;

import com.shengda.base.enums.ErrorCodeEnum;

/**
 * @author takesi
 * @date 2020-03-25
 */
public enum UacBizErrorCode implements ErrorCodeEnum {

    /**
     * 资源不存在
     */
    RESOURCE_NOT_FOUNT {
        @Override
        public int code() {
            return 400;
        }

        @Override
        public String msg() {
            return "资源不存在";
        }
    };

    @Override
    public ErrorCodeEnum getInstance(int code) {
        for (UacBizErrorCode errorCode : UacBizErrorCode.values()) {
            if (errorCode.code() == code) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("非法参数");
    }
}
