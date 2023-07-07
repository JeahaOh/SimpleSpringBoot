package com.example.spring_study.mvc.domain.dto;

import com.example.spring_study.mvc.domain.type.BoardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jeaha on 2023/06/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    private boolean delYn;
    
    public BoardRequest(BoardType boardType, String title, String contents) {
        this.boardType = boardType;
        this.title = title;
        this.contents = contents;
    }
}
