package com.shengda.storage.enums;

/**
 * @author takesi
 * @date 2020-03-26
 */
public enum BucketType {

    /**
     * minio
     */
    MINIO {
        @Override
        public Short getValue() {
            return 1;
        }
    },

    ALIYUN_OSS {
        @Override
        public Short getValue() {
            return 2;
        }
    },

    QINIU_OSS {
        @Override
        public Short getValue() {
            return 3;
        }
    };

    public abstract Short getValue();

    public static BucketType getInstance(Short value) {
        for (BucketType type : BucketType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("非法参数");
    }

}
