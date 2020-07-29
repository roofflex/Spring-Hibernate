package com.roofflex.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
