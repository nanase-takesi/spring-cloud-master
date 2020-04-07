package com.shengda.storage.controller;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.storage.domain.MultipartFileParam;
import com.shengda.storage.service.MinioStorageService;
import lombok.AllArgsConstructor;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2020-04-06
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/minio")
public class MinioController extends BaseController {

    private final MinioStorageService minioStorageService;

    @PostMapping(value = "/{bucket}/upload")
    public Wrapper<String> upload(@PathVariable String bucket, @RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String result = minioStorageService.upload(bucket, file.getInputStream(), file.getSize(),
                fileName,
                MediaType.APPLICATION_OCTET_STREAM_VALUE);
        return WrapMapper.ok(result);
    }

    @PostMapping(value = "/{bucket}/presigned_upload")
    public Wrapper<String> presignedUpload(@PathVariable String bucket, @RequestParam String ext) {
        String result = minioStorageService.presignedUpload(bucket, ext);
        return WrapMapper.ok(result);
    }

    @PostMapping(value = "/{bucket}/chunk_upload")
    public Wrapper<String> chunkUpload(@PathVariable String bucket, MultipartFileParam param,
                                       HttpServletRequest request, HttpServletResponse response) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            //TODO 分片上传
        }
        return WrapMapper.error("不支持的表单格式");
    }

}
