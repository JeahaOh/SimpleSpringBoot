package com.example.spring_study.mvc.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * Created by jeaha on 2023/07/05
 */
@Slf4j
@Component
public class SampleSchedule {
    @Scheduled(cron = "#{@sampleScheduleCron}")
    public void sampleSchedule() {
        log.info("sample schedule is running : {}", Calendar.getInstance().getTime());
    }
}
