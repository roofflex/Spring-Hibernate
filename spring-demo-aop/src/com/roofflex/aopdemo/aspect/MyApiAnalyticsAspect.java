package com.roofflex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {


    // adding Api advice
    @Before("AopExpressions.forDAOpackageNoGettersSetters()")
    public void performAPIAnalytics(){
        System.out.println("\n=======>> Doing some analytics");
    }
}
