package com.roofflex.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Swim 750m as fast as you can";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
