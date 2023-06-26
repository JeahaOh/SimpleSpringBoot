package com.example.spring_study.mvc.dto;

import lombok.Data;

/**
 * Created by jeaha on 2023/06/17
 */
@Data
public class BoardRequest {
    private int boardSeq;
    private String title;
    private String contents;
}
