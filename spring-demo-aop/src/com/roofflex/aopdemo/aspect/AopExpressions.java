package com.roofflex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // using Pointcut declaration
    @Pointcut("execution(* com.roofflex.aopdemo.dao.*.*(..))")
    public void forDAOpackage() {}

    // pointcut declaration for getter methods
    @Pointcut("execution(* com.roofflex.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // pointcut declaration for setter methods
    @Pointcut("execution(* com.roofflex.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // custom pointcut declaration for all methods in DAO package excluding getter & setter methods
    @Pointcut("forDAOpackage() && !(getter() || setter()))")
    public void forDAOpackageNoGettersSetters() {}
}
