package com.shengda.base.enums;

/**
 * @author takesi
 * @date 2019-12-28
 */
public enum GlobalErrorCodeEnum implements ErrorCodeEnum {

    /**
     * Gl 99990100 error code enum.
     */
    GL99990100 {
        @Override
        public int code() {
            return 9999100;
        }

        @Override
        public String msg() {
            return "参数异常";
        }
    },
    /**
     * Gl 99990401 error code enum.
     */
    GL99990401 {
        @Override
        public int code() {
            return 99990401;
        }

        @Override
        public String msg() {
            return "无访问权限";
        }
    },
    /**
     * Gl 000500 error code enum. 500, "未知异常"
     */
    GL99990500 {
        @Override
        public int code() {
            return 500;
        }

        @Override
        public String msg() {
            return "未知异常";
        }
    },
    /**
     * Gl 000403 error code enum. 9999403, "无权访问"
     */
    GL99990403 {
        @Override
        public int code() {
            return 9999403;
        }

        @Override
        public String msg() {
            return "无权访问";
        }
    },
    /**
     * Gl 000404 error code enum. 9999404, "找不到指定资源"
     */
    GL9999404 {
        @Override
        public int code() {
            return 9999404;
        }

        @Override
        public String msg() {
            return "找不到指定资源";
        }
    },
    /**
     * Gl 99990001 error code enum. 99990001, "注解使用错误"
     */
    GL99990001 {
        @Override
        public int code() {
            return 99990001;
        }

        @Override
        public String msg() {
            return "注解使用错误";
        }
    },
    /**
     * Gl 99990002 error code enum. 99990002, "微服务不在线,或者网络超时"
     */
    GL99990002 {
        @Override
        public int code() {
            return 99990002;
        }

        @Override
        public String msg() {
            return "微服务不在线,或者网络超时";
        }
    };

    @Override
    public ErrorCodeEnum getInstance(int code) {
        for (ErrorCodeEnum ele : GlobalErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        throw new IllegalArgumentException("非法参数!");
    }
}
