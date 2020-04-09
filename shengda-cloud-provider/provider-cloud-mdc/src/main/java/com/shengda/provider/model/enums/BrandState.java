package com.shengda.provider.model.enums;

/**
 * @author takesi
 * @date 2020-04-09
 */
public enum BrandState {

    /**
     * 使用中
     */
    IN_USE {
        @Override
        public Short getValue() {
            return 1;
        }
    },

    /**
     * 已作废
     */
    INVALID {
        @Override
        public Short getValue() {
            return 0;
        }
    };

    public abstract Short getValue();

}
