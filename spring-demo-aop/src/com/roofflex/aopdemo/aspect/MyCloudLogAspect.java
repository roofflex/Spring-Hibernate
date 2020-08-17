package com.roofflex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    // adding cloud logging advice
    @Before("AopExpressions.forDAOpackageNoGettersSetters()")
    public void logToCloud(){
        System.out.println("\n=======>> Logging info to cloud");
    }
}
