package com.example.spring_study.mvc.config.web;

import com.example.spring_study.mvc.common.exception.CommonException;
import com.example.spring_study.mvc.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by jeaha on 2023/06/27
 */
@ControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {
    private final MessageSource messageSource;
    
    @ExceptionHandler(value = {CommonException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private CommonResponse<?> handleBaseException(CommonException e, WebRequest request) {
        return new CommonResponse<String>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(), e.getArgs(), null));
    }
}
