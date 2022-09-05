package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class StudentAspect {

    @AfterReturning(pointcut =
            "execution(* com.codegym.controller.StudentController.*(..))")
    public void logInfoProcessing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method " + methodName + " da chay xong!");
        System.err.println(args);
    }
}
