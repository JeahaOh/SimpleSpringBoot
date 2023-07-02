package com.example.spring_study.mvc.config.web.bind;

import java.lang.annotation.*;

/**
 * Created by jeaha on 2023/07/01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestConfig {
    boolean loginCheck() default false;
}
