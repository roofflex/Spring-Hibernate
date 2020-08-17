package com.roofflex.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean tripwire){

        if (tripwire){
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        // simulate a delay
        try{
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException exc){
            exc.printStackTrace();
        }

        // return Fortune
        return "Expect heavy traffic this morning!";
    }
}
