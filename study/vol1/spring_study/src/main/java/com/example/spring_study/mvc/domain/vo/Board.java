package com.example.spring_study.mvc.domain.vo;

import com.example.spring_study.mvc.domain.type.BoardType;
import lombok.Data;

import java.util.Date;

/**
 * Created by jeaha on 2023/06/17
 */
@Data
public class Board {
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    private Date regData;
}
