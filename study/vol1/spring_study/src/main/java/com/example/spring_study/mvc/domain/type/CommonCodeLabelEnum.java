package com.example.spring_study.mvc.domain.type;

/**
 * 기본 Code label Enum
 * Created by jeaha on 2023/06/30
 */
public interface CommonCodeLabelEnum {
    
    /**
     * 코드를 리턴.
     * @return
     */
    String code();
    
    /**
     * 라벨(코드명)을 리턴.
     * @return
     */
    String label();
}
