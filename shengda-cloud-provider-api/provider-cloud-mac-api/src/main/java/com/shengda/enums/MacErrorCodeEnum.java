package com.shengda.enums;

import com.shengda.base.enums.ErrorCodeEnum;

/**
 * @author takesi
 * @date 2019-12-28
 */
public enum MacErrorCodeEnum implements ErrorCodeEnum {

    /**
     * 新建系统公告失败
     */
    MAC100600001 {
        @Override
        public int code() {
            return 100600001;
        }

        @Override
        public String msg() {
            return "新建系统公告失败";
        }
    },
    /**
     * 系统公告不存在
     */
    MAC100600002 {
        @Override
        public int code() {
            return 100600002;
        }

        @Override
        public String msg() {
            return "系统公告不存在";
        }
    },
    /**
     * 新建轮播痛失败
     */
    MAC100600011 {
        @Override
        public int code() {
            return 100600011;
        }

        @Override
        public String msg() {
            return "新建轮播图失败";
        }
    },
    /**
     * 轮播图不存在
     */
    MAC100600012 {
        @Override
        public int code() {
            return 100600012;
        }

        @Override
        public String msg() {
            return "轮播图不存在";
        }
    },
    /**
     * 新建推荐位失败
     */
    MAC100600021 {
        @Override
        public int code() {
            return 100600021;
        }

        @Override
        public String msg() {
            return "新建推荐位失败";
        }
    },
    /**
     * 推荐位不存在
     */
    MAC100600022 {
        @Override
        public int code() {
            return 100600022;
        }

        @Override
        public String msg() {
            return "推荐位不存在";
        }
    },


    /**
     * 新建名片失败
     */
    MAC100600031 {
        @Override
        public int code() {
            return 100600031;
        }

        @Override
        public String msg() {
            return "新建名片失败";
        }
    },

    /**
     * 名片已存在
     */
    MAC100600032 {
        @Override
        public int code() {
            return 100600032;
        }

        @Override
        public String msg() {
            return "名片已存在";
        }
    },
    /**
     * 名片不存在
     */
    MAC100600033 {
        @Override
        public int code() {
            return 100600033;
        }

        @Override
        public String msg() {
            return "名片不存在";
        }
    },
    /**
     * 名片轮播创建失败
     */
    MAC100600041 {
        @Override
        public int code() {
            return 100600041;
        }

        @Override
        public String msg() {
            return "名片轮播创建失败";
        }
    },
    /**
     * 名片轮播不存在
     */
    MAC100600042 {
        @Override
        public int code() {
            return 100600042;
        }

        @Override
        public String msg() {
            return "名片轮播不存在";
        }
    },
    /**
     * 名片公告创建失败
     */
    MAC100600051 {
        @Override
        public int code() {
            return 100600051;
        }

        @Override
        public String msg() {
            return "名片公告创建失败";
        }
    },
    /**
     * 名片公告不存在
     */
    MAC100600052 {
        @Override
        public int code() {
            return 100600052;
        }

        @Override
        public String msg() {
            return "名片公告不存在";
        }
    },
    /**
     * 名片图标创建失败
     */
    MAC100600061 {
        @Override
        public int code() {
            return 100600061;
        }

        @Override
        public String msg() {
            return "名片图标创建失败";
        }
    },
    /**
     * 名片图标不存在
     */
    MAC100600062 {
        @Override
        public int code() {
            return 100600062;
        }

        @Override
        public String msg() {
            return "名片图标不存在";
        }
    },
    /**
     * 创建文章失败
     */
    MAC100600071 {
        @Override
        public int code() {
            return 100600071;
        }

        @Override
        public String msg() {
            return "创建文章失败";
        }
    },
    /**
     * 文章不存在
     */
    MAC100600072 {
        @Override
        public int code() {
            return 100600072;
        }

        @Override
        public String msg() {
            return "文章不存在";
        }
    },
    /**
     * 创建视频失败
     */
    MAC100600081 {
        @Override
        public int code() {
            return 100600081;
        }

        @Override
        public String msg() {
            return "创建视频失败";
        }
    },
    /**
     * 视频不存在
     */
    MAC100600082 {
        @Override
        public int code() {
            return 100600082;
        }

        @Override
        public String msg() {
            return "视频不存在";
        }
    },
    /**
     * 微信用户不存在
     */
    MAC100600091 {
        @Override
        public int code() {
            return 100600091;
        }

        @Override
        public String msg() {
            return "微信用户不存在";
        }
    };

    @Override
    public ErrorCodeEnum getInstance(int code) {
        for (ErrorCodeEnum ele : MacErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        throw new IllegalArgumentException("非法参数!");
    }
}
