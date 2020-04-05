package com.shengda.provider.controller;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.constant.MdcConstant;
import com.shengda.core.support.BaseController;
import com.shengda.storage.service.MinioStorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author takesi
 * @date 2020-04-04
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/minio")
public class MinioController extends BaseController {

    private MinioStorageService minioStorageService;

    @PostMapping(value = "/upload")
    public Wrapper<String> upload(@RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String result = minioStorageService.upload(MdcConstant.BUCK_NAME, file.getInputStream(), file.getSize(),
                fileName,
                MediaType.APPLICATION_OCTET_STREAM_VALUE);
        return WrapMapper.ok(result);
    }

    @GetMapping(value = "/presigned")
    public Wrapper<String> presignedGetObject(@RequestParam String projectName) {
        String result = minioStorageService.presignedGetObject(MdcConstant.BUCK_NAME, projectName);
        return WrapMapper.ok(result);
    }

}
