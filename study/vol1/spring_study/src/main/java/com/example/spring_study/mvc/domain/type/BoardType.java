package com.example.spring_study.mvc.domain.type;

import java.util.Random;

/**
 * Created by jeaha on 2023/06/30
 */
public enum BoardType implements CommonCodeLabelEnum {
    NOTICE("공지사항"),
    NORMAL("일반 게시물"),
    FAQ("자주 묻는 질문"),
    INQUIRY("1:1 문의"),
    UNIDENTIFIED("정의되지 않음");
    
    private String code;
    private String label;
    
    
    BoardType(String label) {
        this.code = name();
        this.label = label;
    }
    
    @Override
    public String code() {
        return this.code;
    }
    
    @Override
    public String label() {
        return this.label;
    }
    
    public static BoardType genRandom() {
        final Random random = new Random(System.currentTimeMillis());
        BoardType[] types = values();
        
        return types[random.nextInt(types.length)];
    }
}
