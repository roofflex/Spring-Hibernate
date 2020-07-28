package com.roofflex.springdemo;

public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Play 3 games of tennis against me";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
