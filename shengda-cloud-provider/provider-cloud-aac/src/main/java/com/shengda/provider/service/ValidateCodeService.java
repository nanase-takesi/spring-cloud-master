package com.shengda.provider.service;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.exception.ValidateCodeException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author takesi
 * @date 2020-03-29
 */
public interface ValidateCodeService {

    /**
     * 保存图形验证码
     *
     * @param deviceId  前端唯一标识
     * @param imageCode 验证码
     */
    void saveImageCode(String deviceId, String imageCode);

    /**
     * 发送smsCode
     *
     * @param mobile mobile
     * @return Wrapper
     */
    Wrapper<String> sendSmsCode(String mobile);

    /**
     * 获取验证码
     *
     * @param deviceId 前端唯一标识/手机号
     * @return String
     */
    String getCode(String deviceId);

    /**
     * 删除验证码
     *
     * @param deviceId 前端唯一标识/手机号
     */
    void remove(String deviceId);

    /**
     * 验证验证码
     *
     * @param request request
     * @throws ValidateCodeException ValidateCodeException
     */
    void validate(HttpServletRequest request) throws ValidateCodeException;
}

