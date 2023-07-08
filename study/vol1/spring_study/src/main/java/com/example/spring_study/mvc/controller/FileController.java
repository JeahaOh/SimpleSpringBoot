package com.example.spring_study.mvc.controller;

import com.example.spring_study.mvc.common.exception.CommonException;
import com.example.spring_study.mvc.common.response.CommonResponse;
import com.example.spring_study.mvc.common.response.CommonResponseCode;
import com.example.spring_study.mvc.config.GlobalConfig;
import com.example.spring_study.mvc.domain.dto.UploadFileRequest;
import com.example.spring_study.mvc.service.UploadedFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    private final UploadedFileService uploadedFileService;
    
    // 좋은 구조는 아닌데...
    // 경로 지정도 이게 아닌 것 같은데...
    @PostMapping("/save")
    @ApiOperation(value = "File Upload", notes = "")
    public CommonResponse<Boolean> save(
            HttpServletRequest request,
            @RequestParam("uploadFile")MultipartFile uploadFile
            ) {
        
        if (uploadFile == null || uploadFile.isEmpty()) {
            throw new CommonException(CommonResponseCode.DATA_IS_NULL, new String[]{"upload file"});
        }
        
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String root = request.getServletContext().getRealPath(File.separator);
        log.debug("root : {}", root);
        
        log.debug("uploadFile : {}, config : {}", uploadFile, config);
        String uploadFilePath = String.format("%s%s%s%s", root, config.getUploadFilePath(), currentDate,"/");
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
        String resourcePathname = String.format("%s%s%s", config.getUploadFilePath(), currentDate,"/");
        log.debug("fullPathAndName : {}, resourcePathname : {}", fullPathAndName, resourcePathname);
        File dest = new File(fullPathAndName);
        
        try {
            // 저장
            uploadFile.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            log.error("MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
            throw new CommonException(CommonResponseCode.ERROR, new String[]{"저장 실패"});
        }
    
        UploadFileRequest uploadFileRequest = UploadFileRequest.builder()
                .contentType(uploadFile.getContentType())
                .originFilename(uploadFile.getOriginalFilename())
                .filename(savedFileName)
                .pathname(uploadFilePath)
                .size((int) uploadFile.getSize())
                .resourcePathname(resourcePathname)
                .build();
        
        uploadedFileService.save(uploadFileRequest);
        
        return new CommonResponse<>(true);
    }
}
