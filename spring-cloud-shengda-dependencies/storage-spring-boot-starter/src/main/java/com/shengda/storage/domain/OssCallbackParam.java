package com.shengda.storage.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * oss上传成功后的回调参数
 *
 * @author takesi
 * @date 2020-03-17
 */
@Data
public class OssCallbackParam implements Serializable {

    private static final long serialVersionUID = 6065194936491014475L;

    /**
     * 请求的回调地址
     */
    private String callbackUrl;

    /**
     * 回调是传入request中的参数
     */
    private String callbackBody;

    /**
     * 回调时传入参数的格式，比如表单提交形式
     */
    private String callbackBodyType;

}
