package com.example.spring_study.mvc.service;

import com.example.spring_study.mvc.domain.common.PageRequestParameter;
import com.example.spring_study.mvc.domain.dto.BoardRequest;
import com.example.spring_study.mvc.domain.dto.BoardSearchRequest;
import com.example.spring_study.mvc.domain.vo.Board;
import com.example.spring_study.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeaha on 2023/06/17
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    
    private final BoardRepository repository;
    
    /**
     * 게시판 목록 리턴.
     * @return
     */
    public List<Board> getList(PageRequestParameter<BoardSearchRequest> pageRequestParameter) {
        return repository.getList(pageRequestParameter);
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
            log.debug("parameter : {}", parameter);
            repository.save(parameter);
        } else {
            repository.update(parameter);
        }
        return parameter.getBoardSeq();
    }
    
    /**
     * 단순 반복문을 이용한 등록 처리
     */
    public void saveListAsJavaLoop(List<BoardRequest> list) {
        for (BoardRequest boardRequest : list) {
            repository.save(boardRequest);
        }
    }
    
    /**
     * 100개씩 배역에 담아서 일괄 등록 처리
     */
    public void saveListAsMybatisLoop(List<BoardRequest> boardList) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("boardList", boardList);
        repository.saveList(paramMap);
    }
    /**
     * 게시판 삭제 처리.
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
