package com.shengda.storage.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * oss上传文件的回调结果
 *
 * @author takesi
 * @date 2020-03-17
 */
@Data
public class OssCallbackResult implements Serializable {

    private static final long serialVersionUID = -6399579272044982663L;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 文件的mimeType
     */
    private String mimeType;

    /**
     * 图片文件的宽
     */
    private String width;

    /**
     * 图片文件的高
     */
    private String height;

}
