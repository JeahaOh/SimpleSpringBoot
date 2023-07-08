package com.example.spring_study.mvc.repository;

import com.example.spring_study.mvc.domain.common.PageRequestParameter;
import com.example.spring_study.mvc.domain.dto.BoardRequest;
import com.example.spring_study.mvc.domain.dto.BoardSearchRequest;
import com.example.spring_study.mvc.domain.dto.UploadFileRequest;
import com.example.spring_study.mvc.domain.vo.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jeaha on 2023/06/17
 */
@Repository
public interface UploadFileRepository {
    void save(UploadFileRequest parameter);
}
