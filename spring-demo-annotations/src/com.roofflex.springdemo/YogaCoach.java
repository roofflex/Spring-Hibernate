package com.roofflex.springdemo;

public class YogaCoach implements Coach {

    private FortuneService fortuneService;

    public YogaCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Stretch for 20 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
