package com.shengda.storage.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取OSS上传文件授权返回结果
 *
 * @author takesi
 * @date 2020-03-17
 */
@Data
public class OssPolicyResult implements Serializable {

    private static final long serialVersionUID = 4780997715771206863L;
    /**
     * 访问身份验证中用到用户标识
     */
    private String accessKeyId;

    /**
     * 用户表单上传的策略,经过base64编码过的字符串
     */
    private String policy;

    /**
     * 对policy签名后的字符串
     */
    private String signature;

    /**
     * 上传文件夹路径前缀
     */
    private String dir;

    /**
     * oss对外服务的访问域名
     */
    private String host;

    /**
     * oss过期时间
     */
    private String expire;

    /**
     * oss上传文件名
     */
    private String key;

    /**
     * 上传成功后的回调设置
     */
    private String callback;

}
