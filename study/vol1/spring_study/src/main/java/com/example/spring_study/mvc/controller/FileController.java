package com.example.spring_study.mvc.controller;

import com.example.spring_study.mvc.common.exception.CommonException;
import com.example.spring_study.mvc.common.response.CommonResponse;
import com.example.spring_study.mvc.common.response.CommonResponseCode;
import com.example.spring_study.mvc.config.GlobalConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
    
    @PostMapping("/save")
    @ApiOperation(value = "File Upload", notes = "")
    public CommonResponse<Boolean> save(
            @RequestParam("uploadFile")MultipartFile uploadFile
            ) {
        
        if (uploadFile == null || uploadFile.isEmpty()) {
            throw new CommonException(CommonResponseCode.DATA_IS_NULL, new String[]{"upload file"});
        }
        
        log.debug("uploadFile : {}, config : {}", uploadFile, config);
        String uploadFilePath = config.getUploadFilePath();
        log.debug("uploadFilePath : {}", uploadFilePath);
        
        File dir = new File(uploadFilePath);
        log.debug("\ndir : {} -> {}", uploadFilePath, dir.getAbsolutePath());
        if (!dir.isDirectory()) {
            dir.mkdirs();
            log.debug("\nMKDIR : {} -> {}", uploadFilePath, dir.getAbsolutePath());
        }
        
        // 확장자
        String extName = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1);
        // 저장될 이름
        String savedFileName = String.format("%s.%s", UUID.randomUUID().toString(), extName);
        log.debug("savedFileName : {}", savedFileName);
        
        // 경로 + 저장될 이름
        String fullPathAndName = uploadFilePath + savedFileName;
        log.debug("fullPathAndName : {}", fullPathAndName);
        File dest = new File(fullPathAndName);
        
        try {
            uploadFile.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            log.error("MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
            throw new CommonException(CommonResponseCode.ERROR, new String[]{"저장 실패"});
        }
    
        return new CommonResponse<>(true);
    }
}
