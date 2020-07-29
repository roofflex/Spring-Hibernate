package com.roofflex.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune()+"\n\n");

        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        //close context
        context.close();
    }
}
