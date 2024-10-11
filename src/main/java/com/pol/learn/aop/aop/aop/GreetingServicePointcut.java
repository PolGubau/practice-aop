package com.pol.learn.aop.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {
    @Pointcut("execution(* com.pol.learn.aop.aop.services.GreetingService.*(..))")
    public void greetingLogger2Pointcut() {
    }

    @Pointcut("execution(* com.pol.learn.aop.aop.services.GreetingService.*(..))")
    public void greetingLoggerPointcut() {
    }

}
