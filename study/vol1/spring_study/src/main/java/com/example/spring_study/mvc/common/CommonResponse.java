package com.example.spring_study.mvc.common;

import lombok.Data;

/**
 * Created by jeaha on 2023/06/22
 */
@Data
public class CommonResponse<T> {
    private CommonResponseCode code;
    private String message;
    private T data;
    
    public CommonResponse(T data) {
        this.code = CommonResponseCode.SUCCESS;
        this.data = data;
    }
}
