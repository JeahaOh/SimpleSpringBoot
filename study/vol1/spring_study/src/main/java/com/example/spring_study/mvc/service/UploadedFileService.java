package com.example.spring_study.mvc.service;

import com.example.spring_study.mvc.domain.dto.UploadFileRequest;
import com.example.spring_study.mvc.repository.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by jeaha on 2023/06/17
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UploadedFileService {
    
    private final UploadFileRepository repository;
    
    /**
     * 첨부파일 저장 처리.
     *
     * @param parameter
     */
    public void save(UploadFileRequest parameter) {
        log.debug("parameter : {}", parameter);
        repository.save(parameter);
    }
}
