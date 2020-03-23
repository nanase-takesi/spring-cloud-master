package com.shengda.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Data
public class UploadFileDto implements Serializable {

    private static final long serialVersionUID = -55291897501171378L;

    private String fileName;

    private String url;

    private String fileType;

    private Long size;

    public UploadFileDto() {
        super();
    }

    public UploadFileDto(String fileName, String url, String fileType, Long size) {
        this.fileName = fileName;
        this.url = url;
        this.fileType = fileType;
        this.size = size;
    }
}
