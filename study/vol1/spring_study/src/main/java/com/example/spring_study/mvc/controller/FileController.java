package com.example.spring_study.mvc.controller;

import com.example.spring_study.mvc.common.response.CommonResponse;
import com.example.spring_study.mvc.config.GlobalConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeaha on 2023/06/25
 */
@Slf4j
@RequiredArgsConstructor
@Api(tags = "File API")
@RestController
@RequestMapping("/file")
public class FileController {
    
    private final GlobalConfig config;
    
    @GetMapping
    @ApiOperation(value = "File Upload", notes = "")
    public CommonResponse<Boolean> save() {
        log.debug("config : {}", config);
        String uploadFilePath = config.getUploadFilePath();
        log.debug("uploadFilePath : {}", uploadFilePath);
        return new CommonResponse<>(true);
    }
}
