package com.example.spring_study.mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * 이 방법보단 @Value가 월등히 낫다고 생각 된다.
 * 장점이 어느 순간에서 빛을 발할지 잘 모르겠음.
 * 차라리 호출받을 대마다 properties 파일을 읽어오는게 나을 것 같은 느낌
 * Created by jeaha on 2023/06/25
 */
@Slf4j
public class GlobalConfig {
    @Autowired
    ApplicationContext context;
    
    @Autowired
    ResourceLoader resourceLoader;
    
    private String uploadFilePath;
    
    private boolean isLocal;
    private boolean isDev;
    private boolean isProd;
    
    @PostConstruct
    public void init() {
        log.info("GlobalConfig -> init");
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        String activeProfile = "local";
        
        if (ObjectUtils.isNotEmpty(activeProfiles)) {
            activeProfile = activeProfiles[0];
        }
        // log.debug("activeProfile : {}", activeProfile);
        
        String resourcePath = String.format("classpath:globals/globals-%s.properties", activeProfile);
        // log.debug("resourcePath : {}", resourcePath);
        
        try {
            Resource resource = resourceLoader.getResource(resourcePath);
            // log.debug("resource : {}", resource);
            
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            log.debug("properties : {}", properties);
            
            uploadFilePath =  properties.getProperty("uploadFile.path");
            // log.debug("uploadFilePath : {}", uploadFilePath);
            
            this.isLocal = activeProfile.equals("local");
            this.isDev = activeProfile.equals("dev");
            this.isProd = activeProfile.equals("prod");
        } catch (Exception e) {
            log.error("MSG: {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
        }
    }
    
    public String getUploadFilePath() {
        return uploadFilePath;
    }
    
    public boolean isLocal() {
        return isLocal;
    }
    
    public boolean isDev() {
        return isLocal;
    }
    
    public boolean isProd() {
        return isLocal;
    }
}
