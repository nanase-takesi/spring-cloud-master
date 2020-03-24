package com.shengda.provider.model.enums;

/**
 * @author takesi
 * @date 2020-03-24
 */
public enum DepartmentState {
    /**
     * enable
     */
    ENABLE {
        @Override
        public boolean getValue() {
            return true;
        }
    },
    /**
     * disable
     */
    DISABLE {
        @Override
        public boolean getValue() {
            return false;
        }
    };

    public abstract boolean getValue();

    public static DepartmentState getInstance(Boolean value) {
        for (DepartmentState state : DepartmentState.values()) {
            if (state.getValue() == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("非法参数!");
    }
}
