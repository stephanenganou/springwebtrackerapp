package com.simpleapp.havefun.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
@EnableAspectJAutoProxy
@Slf4j
public class AspectJConfig {

    @Pointcut("execution(* com.simpleapp.havefun.web.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.simpleapp.havefun.business.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.simpleapp.havefun.data.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        // display calling method
        String theMethod = theJoinPoint.getSignature().toShortString();
        log.info("========>> in @Before: calling method: {}", theMethod);

        // display the arguments to the method
    }
}
