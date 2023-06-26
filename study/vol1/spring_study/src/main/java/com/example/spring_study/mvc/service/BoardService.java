package com.example.spring_study.mvc.service;

import com.example.spring_study.mvc.dto.BoardRequest;
import com.example.spring_study.mvc.vo.Board;
import com.example.spring_study.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeaha on 2023/06/17
 */
@RequiredArgsConstructor
@Service
public class BoardService {
    
    private final BoardRepository repository;
    
    /**
     * 게시판 목록 리턴.
     * @return
     */
    public List<Board> getList() {
        return repository.getList();
    }
    
    /**
     * 게시판 상세정보 리턴.
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq) {
        return repository.get(boardSeq);
    }
    
    /**
     * 게시판 저장 처리.
     * @param parameter
     */
    public int save(BoardRequest parameter) {
        Board board = repository.get(parameter.getBoardSeq());
        if (board == null) {
            repository.save(parameter);
        } else {
            repository.update(parameter);
        }
        return parameter.getBoardSeq();
    }
    
    /**
     * 게시판 삭제 처리.
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
