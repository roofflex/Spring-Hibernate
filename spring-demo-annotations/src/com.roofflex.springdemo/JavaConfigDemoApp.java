package com.roofflex.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach swimmingCoach = context.getBean("swimmingCoach", Coach.class);

        //call a method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune()+"\n\n");

        System.out.println(swimmingCoach.getDailyWorkout());
        System.out.println(swimmingCoach.getDailyFortune());

        //close context
        context.close();
    }
}
