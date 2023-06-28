package com.example.spring_study.mvc.common.response;

import lombok.Data;
import lombok.Getter;

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
    
    public CommonResponse(CommonResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
