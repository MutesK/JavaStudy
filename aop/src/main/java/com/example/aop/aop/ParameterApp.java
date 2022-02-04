package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component  // Spring에서 관리
public class ParameterApp
{
    // Pointer Cut(Rule)
    // com.example.aop.controller 하위
    // https://icarus8050.tistory.com/8
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void PointCut()
    {

    }

    @Before("PointCut()")  // PointCut함수가 실행되기 지점 전에 실행한다.
    public void before(JoinPoint joinPoint)
    {
        MethodSignature signiture = (MethodSignature)joinPoint.getSignature();
        Method method = signiture.getMethod();
        System.out.println(method.getName());


        Object[] args = joinPoint.getArgs();

        for(Object arg : args)
        {
            System.out.println("Type " + arg.getClass().getSimpleName());
            System.out.println("Value  " +arg);

        }
    }

    // 메소드가 정상실행 완료뒤에 해당 실행
    @AfterReturning(value = "PointCut()", returning = "object")
    public void after(JoinPoint joinPoint, Object object)
    {
        System.out.println("Return Object Value");
        System.out.println(object);
    }
}
