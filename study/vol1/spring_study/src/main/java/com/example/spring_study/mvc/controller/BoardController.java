package com.example.spring_study.mvc.controller;

import com.example.spring_study.mvc.common.exception.CommonException;
import com.example.spring_study.mvc.common.response.CommonResponse;
import com.example.spring_study.mvc.common.response.CommonResponseCode;
import com.example.spring_study.mvc.dto.BoardRequest;
import com.example.spring_study.mvc.vo.Board;
import com.example.spring_study.mvc.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeaha on 2023/06/17
 */
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Board API ")
@RestController
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService service;
    
    /**
     * 게시판 목록 리턴.
     *
     * @return
     */
    @ApiOperation(value = "select list", notes = "게시물 목록 조회.")
    @GetMapping
    public CommonResponse<List<Board>> getList() {
        return new CommonResponse<>(service.getList());
    }
    
    /**
     * 게시판 상세정보 리턴.
     *
     * @param boardSeq
     * @return
     */
    @ApiOperation(value = "select board detail", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있음.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "board no", example = "1")
    })
    @GetMapping("/{boardSeq}")
    public CommonResponse<Board> get(@PathVariable int boardSeq) {
        Board board = service.get(boardSeq);
        
        if (board == null) {
            throw new CommonException(CommonResponseCode.DATA_IS_NULL, new String[] {"게시물"});
        }
        
        return new CommonResponse<>(board);
    }
    
    /**
     * 게시판 저장/수정 처리.
     *
     * @param parameter
     */
    @ApiOperation(value = "save or update board", notes = "신규 게시물 저장 및 기존 게시물 수정 가능.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "샘플 제목"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "샘플 내용")
    })
    @PostMapping("/save")
    public CommonResponse<Integer> save(BoardRequest parameter) {
        
        if (StringUtils.isEmpty(parameter.getTitle())) {
            throw new CommonException(CommonResponseCode.VALIDATE_REQUIRED, new String[] {"title", "제목"});
        }
        if (StringUtils.isEmpty(parameter.getContents())) {
            throw new CommonException(CommonResponseCode.VALIDATE_REQUIRED, new String[] {"contents", "내용"});
        }
        
        service.save(parameter);
        return new CommonResponse<>(parameter.getBoardSeq());
    }
    
    /**
     * 자바 반복문을 이용한 대용량 등록 처리 test
     * @return
     */
    @ApiOperation( value = "save objects with java loop", notes = "자바 반복문을 이용한 대용량 등록 처리")
    @PutMapping("/saveListAsJavaLoop")
    public CommonResponse<Boolean> saveListAsJavaLoop() {
        int count = 0;
        List<BoardRequest> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            
            list.add(new BoardRequest(title, contents));
            if (count >= 10000) {
                break;
            }
        }
        
        long bgnTime = System.currentTimeMillis();
        service.saveListAsJavaLoop(list);
        long endTime = System.currentTimeMillis();
        log.debug("WASTE TIME : {}", (endTime - bgnTime) / 1000.0);
        
        return new CommonResponse<>(true);
    }
    
    /**
     * MyBatis를 이용한 대용량 등록 처리 test
     * @return
     */
    @ApiOperation( value = "save objects with MyBatis loop", notes = "MyBatis를 이용한 대용량 등록 처리")
    @PutMapping("/saveListAsMyBatisLoop")
    public CommonResponse<Boolean> saveListAsMyBatisLoop() {
        int count = 0;
        List<BoardRequest> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            
            list.add(new BoardRequest(title, contents));
            if (count >= 10000) {
                break;
            }
        }
        
        long bgnTime = System.currentTimeMillis();
        service.saveListAsMybatisLoop(list);
        long endTime = System.currentTimeMillis();
        log.debug("WASTE TIME : {}", (endTime - bgnTime) / 1000.0);
        
        return new CommonResponse<>(true);
    }
    
    /**
     * 게시판 삭제 처리.
     *
     * @param boardSeq
     */
    @ApiOperation(value = "delete board", notes = "게시물 번호에 해당하는 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "board no", example = "1")
    })
    @DeleteMapping("/delete/{boardSeq}")
    public CommonResponse<Boolean> delete(@PathVariable int boardSeq) {
        Board board = service.get(boardSeq);
        if (board == null) return new CommonResponse<>(false);
        service.delete(boardSeq);
        return new CommonResponse<>(true);
    }
}
