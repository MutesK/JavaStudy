package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component   // @Bean 과 @Component 의 차이
public class PerformanceChecker
{
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void PointCut()
    {
    }

    @Pointcut("@annotation(com.example.aop.anotation.Timer)")
    private void EnableTimer()
    {
    }

    @Around("PointCut() && EnableTimer()")
    public void Arround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();

        System.out.println("Total Time : " + stopWatch.getTotalTimeSeconds());
    }
}
