package com.shengda.exception;

import com.shengda.base.enums.ErrorCodeEnum;
import com.shengda.base.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takesi
 * @date 2019-12-25
 */
public class UacBizException extends BusinessException {

    private static final long serialVersionUID = -8417932557993066287L;

    private static Logger logger = LoggerFactory.getLogger(UacBizException.class);

    public UacBizException() {
        super();
    }

    public UacBizException(Integer code, String msg, Object... args) {
        super(code, msg, args);
        logger.error("<==UacBizException, code: {}, message: {}", code, msg);
    }

    public UacBizException(Integer code, String msg) {
        super(code, msg);
        logger.error("<==UacBizException, code: {}, message: {}", code, msg);
    }

    public UacBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        logger.error("<==UacBizException, code: {}, message: {}", codeEnum.code(), codeEnum.code());
    }

    public UacBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        logger.error("UacBizException, code: {}, message: {}", codeEnum.code(), codeEnum.msg());
    }

}
