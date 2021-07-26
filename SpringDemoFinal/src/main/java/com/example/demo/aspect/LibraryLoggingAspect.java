package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LibraryLoggingAspect {

    //set up Logger
    private Logger myLogger=Logger.getLogger(getClass().getName());
    //setup point cut declarations
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void forControllerPackage()
    {

    }

    @Pointcut("execution(* com.example.demo.dao.*.*(..))")
    private void forDaoPackage()
    {

    }
    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    private void forServicePackage()
    {

    }

    @Pointcut("forControllerPackage()||forDaoPackage()||forServicePackage()")
    private void forAppFlow()
    {

    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint)
    {
        //display method we are calling
        String theMethod=theJoinPoint.getSignature().toShortString();
        myLogger.info("Before calling method"+theMethod);
        //display arguments to the method

        //get the arguments
        Object[]args=theJoinPoint.getArgs();

        //loop through and display args
        for(Object tempArg:args)
        {
            myLogger.info("argument"+tempArg);
        }

    }
    // add @Returning advice
    @AfterReturning(pointcut ="forAppFlow()" ,returning = "result")
    public void afterReturning(JoinPoint theJoinPoint,Object result)
    {
        //display method we are returning from
        String theMethod=theJoinPoint.getSignature().toShortString();
        myLogger.info("after calling method"+theMethod);
        //display data returned
        myLogger.info("result"+result);
    }


}