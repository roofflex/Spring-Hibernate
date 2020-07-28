package com.roofflex.springdemo;

public class CricketCoach implements Coach {


    private FortuneService fortuneService;


    private String emailadress;
    private String team;


    public  CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("CricketCoach: inside setter");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
