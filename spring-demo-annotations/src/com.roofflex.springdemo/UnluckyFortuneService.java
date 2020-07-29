package com.roofflex.springdemo;

public class UnluckyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You'll have an upleasant event unexpectedly";
    }
}
