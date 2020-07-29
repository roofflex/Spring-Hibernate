package com.roofflex.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;


    //define a default constructor
    public TennisCoach(){
        System.out.println("Tennis Coach created");
    }

    // define init method
    @PostConstruct
    private void doStartupStuff(){
        System.out.println("TennisCoach inside init method");
    }

    // define destroy method
    @PreDestroy
    private void doCleanupStuff(){
        System.out.println("TennisCoach inside pre-destroy method");
    }

//    // define a setter method
//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService){
//        System.out.println("Tennis Coach inside setter method");
//        fortuneService = theFortuneService;
//    }

    /*
    @Autowired
    public TennisCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }
    */

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
