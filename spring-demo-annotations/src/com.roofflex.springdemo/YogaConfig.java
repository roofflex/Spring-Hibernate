package com.roofflex.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YogaConfig {

    @Bean
    public FortuneService unluckyFortuneService(){
        return new UnluckyFortuneService();
    }

    @Bean
    public Coach yogaCoach(){
        return new YogaCoach(unluckyFortuneService());
    }
}
