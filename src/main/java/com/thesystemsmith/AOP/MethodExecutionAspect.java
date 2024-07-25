package com.thesystemsmith.AOP;

// LoggingAspect.java
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MethodExecutionAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(* UserController.*(..))")
    public void beforeControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before executing UserController method: " + methodName);
    }
}