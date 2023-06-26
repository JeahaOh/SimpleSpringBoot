package com.example.spring_study.mvc.repository;

import com.example.spring_study.mvc.dto.BoardRequest;
import com.example.spring_study.mvc.vo.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeaha on 2023/06/17
 */
@Repository
public interface BoardRepository {
    List<Board> getList();
    Board get(int boardSeq);
    int save(BoardRequest board);
    int update(BoardRequest board);
    void delete(int boardSeq);
}
