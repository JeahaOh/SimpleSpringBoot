package com.example.spring_study.mvc.common.exception;

import com.example.spring_study.mvc.common.response.CommonResponseCode;

/**
 * Created by jeaha on 2023/06/27
 */
public abstract class AbstractCommonException extends RuntimeException {
    private static final long serialVersionUID = 8342235231880246631L;
    
    protected CommonResponseCode responseCode;
    protected Object[] args;
    
    public AbstractCommonException() {
    }
    
    public AbstractCommonException(CommonResponseCode responseCode) {
        this.responseCode = responseCode;
    }
    
    public CommonResponseCode getResponseCode() {
        return responseCode;
    }
    
    public Object[] getArgs() {
        return args;
    }
}
