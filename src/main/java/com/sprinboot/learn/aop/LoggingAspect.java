package com.sprinboot.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Pointcut("execution(* *..UserService.*(..))")
    public void userMethods(){}

    @Before("userMethods()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before the method call using @Before advice : " + joinPoint.getSignature().getName());
    }

    @After("userMethods()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After the method call using @Before advice : " + joinPoint.getSignature().getName());
    }
}

/**
 *
 * @Pointcut(...) = defines where to apply advice
 *
 * @Before(...) = tells when and what to do
 *
 * joinPoint.getSignature().getName() = gives the actual method name
 */
