package com.shengda.provider.controller;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.oauth2.constants.SecurityConstants;
import com.shengda.provider.service.ValidateCodeService;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2020-03-29
 */
@Controller
@AllArgsConstructor
@RequestMapping(value = SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX)
public class ValidateCodeController extends BaseController {

    private final ValidateCodeService validateCodeService;

    @GetMapping(value = "/{deviceId}")
    public void createCode(@PathVariable String deviceId, HttpServletResponse response) throws IOException {
        Assert.notNull(deviceId, "机器码不能为空");
        // 设置请求头为输出图片类型
        CaptchaUtil.setHeader(response);
        // 三个参数分别为宽、高、位数
        GifCaptcha gifCaptcha = new GifCaptcha(100, 35, 4);
        // 设置类型：字母数字混合
        gifCaptcha.setCharType(Captcha.TYPE_DEFAULT);
        // 保存验证码
        validateCodeService.saveImageCode(deviceId, gifCaptcha.text().toLowerCase());
        // 输出图片流
        gifCaptcha.out(response.getOutputStream());
    }

    /**
     * 发送手机验证码
     * 后期要加接口限制
     *
     * @param mobile 手机号
     * @return R
     */
    @ResponseBody
    @GetMapping(SecurityConstants.MOBILE_VALIDATE_CODE_URL_PREFIX + "/{mobile}")
    public Wrapper<String> createCode(@PathVariable String mobile) {
        Assert.notNull(mobile, "手机号不能为空");
        return validateCodeService.sendSmsCode(mobile);
    }

}
