package com.example.spring_study.mvc.domain.dto;

import com.example.spring_study.mvc.domain.type.BoardType;
import lombok.Data;

import java.util.List;

/**
 * 게시물 검색
 * Created by jeaha on 2023/06/17
 */
@Data
public class BoardSearchRequest {
    private String keyword;
    private List<BoardType> boardTypes;
}
