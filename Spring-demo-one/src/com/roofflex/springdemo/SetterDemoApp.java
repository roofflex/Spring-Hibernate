package com.roofflex.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        //load Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from Spring container
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //call methods on bean
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());

        //call new methods to get literal values
        System.out.println("Coach's email: " + theCricketCoach.getEmailadress());
        System.out.println("Coach's team: " + theCricketCoach.getTeam());

        //close contex
        context.close();
    }
}
