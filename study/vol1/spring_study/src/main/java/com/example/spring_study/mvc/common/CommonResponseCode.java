package com.example.spring_study.mvc.common;

/**
 * Created by jeaha on 2023/06/22
 */
public enum CommonResponseCode {
    SUCCESS(200),
    ERROR(500)
    ;
    
    private int status;
    
    CommonResponseCode(int status) {
        this.status = status;
    }
    
    public int status() {
        return this.status;
    }
}
