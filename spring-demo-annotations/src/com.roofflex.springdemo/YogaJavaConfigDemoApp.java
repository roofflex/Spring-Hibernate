package com.roofflex.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class YogaJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(YogaConfig.class);

        Coach theCoach = context.getBean("yogaCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
    }

}
