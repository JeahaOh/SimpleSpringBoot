package com.example.spring_study.mvc.repository;

import com.example.spring_study.mvc.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeaha on 2023/06/17
 */
@Repository
public interface BoardRepository {
    List<Board> getList();
    Board get(int boardSeq);
    void save(Board board);
    void update(Board board);
    void delete(int boardSeq);
}
