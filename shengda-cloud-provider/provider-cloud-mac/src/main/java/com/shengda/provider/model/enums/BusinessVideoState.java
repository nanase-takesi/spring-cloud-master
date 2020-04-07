package com.shengda.provider.model.enums;

/**
 * @author takesi
 * @date 2019-12-25
 */
public enum BusinessVideoState {

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
