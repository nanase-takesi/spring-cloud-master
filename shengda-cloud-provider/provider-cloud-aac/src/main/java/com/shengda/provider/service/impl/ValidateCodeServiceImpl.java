package com.shengda.provider.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.exception.ValidateCodeException;
import com.shengda.oauth2.constants.SecurityConstants;
import com.shengda.provider.service.ValidateCodeService;
import com.shengda.redis.template.RedisRepository;
import com.shengda.service.UserServiceFeignApi;
import com.shengda.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author takesi
 * @date 2020-03-29
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeServiceImpl.class);

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private UserServiceFeignApi userServiceFeignApi;

    @Override
    public void saveImageCode(String deviceId, String imageCode) {
        redisRepository.setExpire(buildKey(deviceId), imageCode, SecurityConstants.DEFAULT_IMAGE_EXPIRE);
    }

    @Override
    public Wrapper<String> sendSmsCode(String mobile) {
        Object tempCode = redisRepository.get(buildKey(mobile));
        if (tempCode != null) {
            logger.error("用户:{}验证码未失效{}", mobile, tempCode);
            return WrapMapper.error("验证码未失效，请失效后再次申请");
        }

        Wrapper<UserVo> wrapper = userServiceFeignApi.getUserByUserMobile(mobile);
        if (wrapper.success() && wrapper.getData() != null) {
            String code = RandomUtil.randomNumbers(4);
            logger.info("短信发送请求消息中心 -> 手机号:{} -> 验证码：{}", mobile, code);
            redisRepository.setExpire(buildKey(mobile), code, SecurityConstants.DEFAULT_IMAGE_EXPIRE);
            return WrapMapper.ok();
        }
        return WrapMapper.error("手机号不存在");
    }

    @Override
    public String getCode(String deviceId) {
        return (String) redisRepository.get(buildKey(deviceId));
    }

    @Override
    public void remove(String deviceId) {
        redisRepository.del(buildKey(deviceId));
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidateCodeException {
        String deviceId = request.getParameter("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求参数中携带deviceId参数");
        }
        String code = this.getCode(deviceId);
        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request, "validCode");
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("请填写验证码");
        }

        if (code == null) {
            throw new ValidateCodeException("验证码不存在或已过期");
        }

        if (!StringUtils.equals(code, codeInRequest.toLowerCase())) {
            throw new ValidateCodeException("验证码不正确");
        }

        this.remove(deviceId);
    }

    private String buildKey(String deviceId) {
        return SecurityConstants.DEFAULT_CODE_KEY + ":" + deviceId;
    }
}
