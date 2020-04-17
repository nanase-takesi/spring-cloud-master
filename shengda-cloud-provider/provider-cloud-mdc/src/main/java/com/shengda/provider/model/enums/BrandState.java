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
        public Boolean getValue() {
            return true;
        }
    },

    /**
     * 已作废
     */
    INVALID {
        @Override
        public Boolean getValue() {
            return false;
        }
    };

    public abstract Boolean getValue();

}
