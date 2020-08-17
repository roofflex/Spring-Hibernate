package com.roofflex.aopdemo.aspect;

import com.roofflex.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // start with @Before advice


    @Before("AopExpressions.forDAOpackageNoGettersSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n========>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object args[] = joinPoint.getArgs();

        // loop through args

        for (Object temparg : args) {
            System.out.println(temparg);
        }
    }

    // create a new @AfterReturning Advice
    @AfterReturning(pointcut = "execution (* com.roofflex.aopdemo.dao.AccountDAO.createAccounts(..))", returning = "accountsList")
    public void afterReturningCreateAccountsAdvice(JoinPoint joinPoint, List<Account> accountsList){

        // print out which method we are advising on
        System.out.println("\n=====>> Executing @AfterReturnig on method: " + ((MethodSignature) joinPoint.getSignature()).toString());

        // print out the result
        System.out.println("\n=====>> The result is: " + accountsList);

        // post-processing the data: converting Values to Uppercase
        convertValuesToUppercase(accountsList);
        System.out.println("\n=====>> The result is: " + accountsList);
    }

    // new @AfterThrowing Advice
    @AfterThrowing(pointcut = "execution (* com.roofflex.aopdemo.dao.AccountDAO.createAccounts(..))", throwing = "theExc")
    public void afterThrowingCreateAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        // print out which method we are advising on
        System.out.println("\n=====>> Executing @AfterThrowing on method: " + ((MethodSignature) joinPoint.getSignature()).toString());

        // log the exception
        System.out.println("\n=====>> The exception: " + theExc);
    }

    @After("execution (* com.roofflex.aopdemo.dao.AccountDAO.createAccounts(..))")
    public void afterFinallyCreateAccountAdvice(JoinPoint joinPoint){
        // print out which method we are advising on
        System.out.println("\n=====>> Executing @After (finally) on method: " + ((MethodSignature) joinPoint.getSignature()).toString());

    }

    @Around("execution (* com.roofflex.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out which method we are advising on
        System.out.println("\n=====>> Executing @Around on method: " + ((MethodSignature) proceedingJoinPoint.getSignature()).toString());

        // get begin timestamp
        long begin = System.currentTimeMillis();

        Object result = null;

        // execute the method
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc){
            // log exception to console
            System.out.println("Caught exception: " + exc.getMessage());

            // give user a custom message(fortune) .. use with caution, since we swallow the exception
            result = "Highway is closed!";
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute and display duration
        long duration = end - begin;
        System.out.println("\n=====>> The duration is: " + duration / 1000.0 + " seconds");

        return result;
    }

    private void convertValuesToUppercase(List<Account> accountsList) {

        // loop through accounts and convert
        for (Account tempAccount : accountsList){

            // get Uppercase name
            String uppercaseName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(uppercaseName);
        }

    }

}
