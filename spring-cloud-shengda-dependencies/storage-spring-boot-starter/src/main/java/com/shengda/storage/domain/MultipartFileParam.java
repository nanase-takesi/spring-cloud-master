package com.shengda.storage.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 文件传输对象
 *
 * @author takesi
 * @date 2020-04-06
 */
@Data
public class MultipartFileParam implements Serializable {

    private static final long serialVersionUID = 4243413623683336938L;

    /**
     * 文件传输任务ID
     */
    private String taskId;

    /**
     * 当前为第几分片
     */
    private int chunk;

    /**
     * 分片总数
     */
    private int chunkTotal;

    /**
     * 主体类型--这个字段是我项目中的其他业务逻辑可以忽略
     */
    private int objectType;

    /**
     * 分块文件传输对象
     */
    private MultipartFile file;

}
