package com.example.spring_study.mvc.domain.vo;

import com.example.spring_study.mvc.domain.type.BoardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by jeaha on 2023/06/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    private Date regData;
}
