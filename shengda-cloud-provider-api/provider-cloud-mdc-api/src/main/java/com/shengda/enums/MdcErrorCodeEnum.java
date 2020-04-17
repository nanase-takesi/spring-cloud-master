package com.shengda.enums;

import com.shengda.base.enums.ErrorCodeEnum;

/**
 * @author takesi
 * @date 2019-12-28
 */
public enum MdcErrorCodeEnum implements ErrorCodeEnum {

    /**
     * 资源不存在
     */
    MAC100600404 {
        @Override
        public int code() {
            return 404;
        }

        @Override
        public String msg() {
            return "资源不存在";
        }
    },

    /**
     * 系统出现错误
     */
    MAC100600500 {
        @Override
        public int code() {
            return 500;
        }

        @Override
        public String msg() {
            return "系统出现错误";
        }
    };

    @Override
    public ErrorCodeEnum getInstance(int code) {
        for (ErrorCodeEnum ele : MdcErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        throw new IllegalArgumentException("非法参数!");
    }
}
