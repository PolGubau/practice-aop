package com.pol.learn.aop.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect2 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("GreetingServicePointcut.greetingLoggerPointcut()")
    public void beforeGreeting(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("Before greeting ")
                .append(method)
                .append(" with params ")
                .append(args)
                .append("-------------------");

        logger.info(sb.toString());
    }

    @After("GreetingServicePointcut.greetingLoggerPointcut()")
    public void afterGreeting(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("after greeting ")
                .append(method)
                .append(" with arguments ")
                .append(args)
                .append("-------------------");

        logger.info(sb.toString());
    }

    @AfterReturning("GreetingServicePointcut.greetingLoggerPointcut()")
    public void afterReturnGreeting(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("2 NO ERROR in ")
                .append(method)
                .append(" with arguments ")
                .append(args)
                .append("-------------------");

        logger.info(sb.toString());
    }

    @AfterThrowing("GreetingServicePointcut.greetingLoggerPointcut()")
    public void afterThrowingGreeting(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("😯ERROR in ")
                .append(method)
                .append(" with arguments ")
                .append(args)
                .append("-------------------");

        logger.info(sb.toString());
    }

    @Around("GreetingServicePointcut.greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) {
        String method = proceedingJoinPoint.getSignature().getName();

        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("Around greeting ")
                .append(method)
                .append(" with arguments ")
                .append(args)
                .append("-------------------");

        Object result = null;
        try {
            logger.info(sb.toString());
            result = proceedingJoinPoint.proceed();
            return result;

        } catch (Throwable e) {
            logger.error(sb.toString(), e);
        }

        return result;

    }
}
