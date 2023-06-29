package com.example.spring_study.mvc.config;

import com.example.spring_study.mvc.common.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * Created by jeaha on 2023/06/27
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(60);
        source.setDefaultLocale(Locale.KOREAN);
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
    
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((loggingInterceptor()));
    }
}
