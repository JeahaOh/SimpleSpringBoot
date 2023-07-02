package com.example.spring_study.mvc.common.response;

/**
 * Created by jeaha on 2023/06/22
 */
public enum CommonResponseCode {
    SUCCESS(200),
    ERROR(500),
    DATA_IS_NULL(404),
    VALIDATE_REQUIRED(415),
    LOGIN_REQUIRED(403)
    ;
    
    private int status;
    
    CommonResponseCode(int status) {
        this.status = status;
    }
    
    public int status() {
        return this.status;
    }
}
