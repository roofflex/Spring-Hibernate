package com.roofflex.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup Logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution (* com.roofflex.springdemo.controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution (* com.roofflex.springdemo.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution (* com.roofflex.springdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    public void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        // display method we are calling
        logger.info("=====>> in @Before: calling method: " + ((MethodSignature) joinPoint.getSignature()).toString());

        // display arguments to the method

        // get the arguments
        Object args[] = joinPoint.getArgs();

        // loop through the args
        for (Object tempArg : args){
            logger.info("=====>> Argument: " + tempArg);
        }

    }


    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

        // display the method we are returning from
        logger.info("=====>> in @AfterReturning: from method: " + ((MethodSignature) joinPoint.getSignature()).toString());

        // display the result returned
        logger.info("=====>> result: " + result);
    }
}
