package com.example.spring_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jeaha on 2023/06/17
 */
@SpringBootApplication
@EnableScheduling
public class SpringStudyApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }
    
}
