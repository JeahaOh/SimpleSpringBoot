package com.example.spring_study.mvc.controller;

import com.example.spring_study.mvc.domain.Board;
import com.example.spring_study.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jeaha on 2023/06/17
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
 
 private final BoardService service;
 
 /**
  * 게시판 목록 리턴.
  * @return
  */
 @GetMapping
 public List<Board> getList() {
  return service.getList();
 }
 
 /**
  * 게시판 상세정보 리턴.
  * @param boardSeq
  * @return
  */
 @GetMapping("/{boardSeq}")
 public Board get(@PathVariable int boardSeq) {
  return service.get(boardSeq);
 }
 
 /**
  * 게시판 저장/수정 처리.
  * @param board
  */
 @PostMapping("/save")
 public void save(Board board) {
  service.save(board);
 }
 
 /**
  * 게시판 삭제 처리.
  * @param boardSeq
  */
 @DeleteMapping("/delete/{boardSeq}")
 public void delete(@PathVariable int boardSeq) {
  service.delete(boardSeq);
 }
}
