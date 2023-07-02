package com.example.spring_study.mvc.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.spring_study.mvc.common.exception.CommonException;
import com.example.spring_study.mvc.common.response.CommonResponseCode;
import com.example.spring_study.mvc.config.web.bind.RequestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by jeaha on 2023/06/24
 */
@Slf4j
public class LoggingInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle requestURI : {}", request.getRequestURI());
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.info("HandlerMethod : {}", handlerMethod);
            RequestConfig requestConfig = handlerMethod.getMethodAnnotation(RequestConfig.class);
            if (requestConfig != null || requestConfig.loginCheck()) {
                throw new CommonException(CommonResponseCode.LOGIN_REQUIRED, new String[] {request.getRequestURI()});
            }
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandle requestURI : {}", request.getRequestURI());
    }
}