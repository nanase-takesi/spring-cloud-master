package com.shengda.provider.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaMessage;
import cn.binarywang.wx.miniapp.constant.WxMaConstants;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.shengda.core.support.BaseController;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author takesi
 * @date 2020-03-13
 */
@RestController
@AllArgsConstructor
public class WxMaPortalController extends BaseController {

    private final WxMaService wxService;
    private final WxMaMessageRouter route;

    @GetMapping(value = "/wx/portal", produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature") String signature, @RequestParam(name = "timestamp") String timestamp, @RequestParam(name = "nonce") String nonce,
                          @RequestParam(name = "echostr") String echostr) {
        logger.info("接收到来自微信服务器的认证消息：signature = [{}], timestamp = [{}], nonce = [{}], echostr = [{}]", signature, timestamp, nonce, echostr);

        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }
        return "非法请求";
    }

    @PostMapping(value = "/wx/portal", produces = "application/xml; charset=UTF-8")
    public String post(@RequestBody String requestBody, @RequestParam(name = "msg_signature", required = false) String msgSignature,
                       @RequestParam(name = "encrypt_type", required = false) String encryptType, @RequestParam(name = "signature", required = false) String signature,
                       @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce) {
        logger.info("\n接收微信请求：[msg_signature=[{}], encrypt_type=[{}], signature=[{}]," +
                        " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                msgSignature, encryptType, signature, timestamp, nonce, requestBody);
        final boolean isJson = Objects.equals(wxService.getWxMaConfig().getMsgDataFormat(),
                WxMaConstants.MsgDataFormat.JSON);

        if (StringUtils.isBlank(encryptType)) {
            // 明文传输的消息
            WxMaMessage inMessage;
            if (isJson) {
                inMessage = WxMaMessage.fromJson(requestBody);
            } else {//xml
                inMessage = WxMaMessage.fromXml(requestBody);
            }
            route.route(inMessage);
            return "success";
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            WxMaMessage inMessage;
            if (isJson) {
                inMessage = WxMaMessage.fromEncryptedJson(requestBody, wxService.getWxMaConfig());
            } else {//xml
                inMessage = WxMaMessage.fromEncryptedXml(requestBody, wxService.getWxMaConfig(),
                        timestamp, nonce, msgSignature);
            }

            route.route(inMessage);
            return "success";
        }

        throw new RuntimeException("不可识别的加密类型：" + encryptType);
    }


}
