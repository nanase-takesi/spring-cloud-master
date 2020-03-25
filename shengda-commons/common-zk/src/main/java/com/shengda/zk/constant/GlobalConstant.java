package com.shengda.zk.constant;

/**
 * @author takesi
 * @date 2020-03-25
 */
public final class GlobalConstant {

    public static final String ZK_REGISTRY_SERVICE_ROOT_PATH = "/shengda/registry/service";
    public static final String ZK_REGISTRY_ID_ROOT_PATH = "/shengda/registry/id";
    public static final String ZK_REGISTRY_PRODUCER_ROOT_PATH = "/shengda/registry/producer";
    public static final String ZK_REGISTRY_CONSUMER_ROOT_PATH = "/shengda/registry/consumer";
    public static final String ZK_REGISTRY_SEQ = "/shengda/seq";

    /**
     * The class Symbol.
     *
     * @author paascloud.net@gmail.com
     */
    public static final class Symbol {
        private Symbol() {
        }

        /**
         * The constant COMMA.
         */
        public static final String COMMA = ",";
        public static final String SPOT = ".";
        /**
         * The constant UNDER_LINE.
         */
        public final static String UNDER_LINE = "_";
        /**
         * The constant PER_CENT.
         */
        public final static String PER_CENT = "%";
        /**
         * The constant AT.
         */
        public final static String AT = "@";
        /**
         * The constant PIPE.
         */
        public final static String PIPE = "||";
        public final static String SHORT_LINE = "-";
        public final static String SPACE = " ";
        public static final String SLASH = "/";
        public static final String MH = ":";

    }

}
