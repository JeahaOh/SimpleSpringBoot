package com.example.spring_study.mvc.repository;

import com.example.spring_study.mvc.domain.dto.BoardRequest;
import com.example.spring_study.mvc.domain.vo.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jeaha on 2023/06/17
 */
@Repository
public interface BoardRepository {
    List<Board> getList();
    Board get(int boardSeq);
    int save(BoardRequest board);
    void saveList(Map<String, Object> paramMap);
    int update(BoardRequest board);
    void delete(int boardSeq);
}
