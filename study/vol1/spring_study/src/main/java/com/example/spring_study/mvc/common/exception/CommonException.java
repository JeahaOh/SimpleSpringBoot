package com.example.spring_study.mvc.common.exception;

import com.example.spring_study.mvc.common.response.CommonResponseCode;

/**
 * Created by jeaha on 2023/06/27
 */
public class CommonException extends AbstractCommonException {
    
    private static final long serialVersionUID = 8342235231880246631L;
    
    public CommonException() {
    }
    
    public CommonException(CommonResponseCode responseCode) {
        this.responseCode = responseCode;
    }
    
    public CommonException(CommonResponseCode responseCode, String[] args) {
        this.responseCode = responseCode;
        this.args = args;
    }
}
