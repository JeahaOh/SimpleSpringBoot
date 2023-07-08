package com.example.spring_study.mvc.config;

import com.example.spring_study.mvc.common.interceptor.LoggingInterceptor;
import com.example.spring_study.mvc.config.web.PageRequestHandleMethodArgumentResolver;
import com.example.spring_study.mvc.domain.type.CommonCodeLabelEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Locale;

/**
 * Created by jeaha on 2023/06/27
 */
@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {
    
    private final GlobalConfig config;
    
    private static final String WINDOWS_DIR_PREFIX = "file:///";
    private static final String LINUX_DIR_PREFIX = "file:";
    
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
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
    
        simpleModule.addSerializer(CommonCodeLabelEnum.class, new CommonCodeLabelEnumJsonSerializer());
        objectMapper.registerModule(simpleModule);
        
        return objectMapper;
    }
    
    @Bean
    public MappingJackson2JsonView mappingJackson2JsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    
        jsonView.setContentType(MediaType.APPLICATION_JSON_VALUE);
        jsonView.setObjectMapper(objectMapper());
        
        return jsonView;
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PageRequestHandleMethodArgumentResolver());
    }
    
    @Bean
    public GlobalConfig config() {
        return this.config;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // static resource uploaded file dir
        String resourcePattern = config.getUploadResourcePath() + "*";
        
        // 아.. 이게 window mac linux 구분이 들어가야...;
        registry.addResourceHandler(resourcePattern).addResourceLocations(LINUX_DIR_PREFIX + config.getUploadFilePath());
    }
}
