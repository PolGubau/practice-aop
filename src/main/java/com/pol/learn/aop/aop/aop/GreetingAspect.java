package com.pol.learn.aop.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.pol.learn.aop.aop.services.GreetingService.*(..))")
    public void beforeGreeting(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        StringBuilder sb = new StringBuilder()
                .append("Before greeting ")
                .append(method)
                .append(" with arguments ")
                .append(args)
                .append("-------------------");

        logger.info(sb.toString());
    }

    public void afterGreeting() {
        logger.info("After greeting");
    }

}
