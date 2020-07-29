package com.roofflex.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings
    private String[] data = {"Beware of the wolf in sheep's clothing",
                                "Diligence is the mother of good luck",
                                "The journey is the reward"};

    //creating a random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        // pick a random string
        int randomInt = random.nextInt(data.length);
        return data[randomInt];
    }
}
