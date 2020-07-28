package com.roofflex.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortunes = {"You'll have a lucky day", "You'll meet a great person today", "You'll get a raise"};

    private Random myRandomGenerator = new Random();

    @Override
    public String getFortune() {
        int randomIntValue = myRandomGenerator.nextInt(fortunes.length);
        return fortunes[randomIntValue];
    }
}
