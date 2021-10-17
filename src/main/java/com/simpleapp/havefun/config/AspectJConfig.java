package com.simpleapp.havefun.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Stephane Nganou Wafo
 * Sets up all the Aspect logs methods.
 */
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
        log.info("========>> In @Before: calling method: {}", theMethod);

        // display the arguments to the method
        displayArgumentsFromBeforeAdvice(theJoinPoint.getArgs());
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        log.info("=====>>> In @AfterReturning: from method: {}", theMethod);

        // display data returned
        log.info("=====>>> Result: {}", theResult);
    }

    private void displayArgumentsFromBeforeAdvice(Object[] args) {
        if (args != null) {
            for (Object arg : args)
                log.info("=====>> argument: {}", arg);
        }
    }
}
