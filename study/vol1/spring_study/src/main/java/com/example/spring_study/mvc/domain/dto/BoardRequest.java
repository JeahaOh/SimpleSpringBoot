package com.example.spring_study.mvc.domain.dto;

import com.example.spring_study.mvc.domain.type.BoardType;
import lombok.Data;

/**
 * Created by jeaha on 2023/06/17
 */
@Data
public class BoardRequest {
    private int boardSeq;
    
    private BoardType boardType;
    private String title;
    private String contents;
    
    public BoardRequest() {
    }
    
    public BoardRequest(BoardType boardType, String title, String contents) {
        this.boardType = boardType;
        this.title = title;
        this.contents = contents;
    }
}
