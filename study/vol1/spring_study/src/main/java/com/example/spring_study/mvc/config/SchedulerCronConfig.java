package com.example.spring_study.mvc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jeaha on 2023/07/05
 */
@RequiredArgsConstructor
@Configuration
public class SchedulerCronConfig {
    private final GlobalConfig config;
    
    @Bean
    public String sampleScheduleCron() {
        return config.getSampleSchedule();
    }
}
