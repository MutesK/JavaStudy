package com.example.aop.aop;

import com.example.aop.dto.User;
import org.apache.tomcat.util.codec.binary.Base64;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Aspect
@Component
public class DecodeAop
{
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void PointCut()
    {
    }

    @Pointcut("@annotation(com.example.aop.anotation.Decode)")
    private void EnableDecode()
    {
    }

    @Before("PointCut() && EnableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException
    {
        Object[] args = joinPoint.getArgs();

        for(Object object : args)
        {
            if(object instanceof User)
            {
                User user = User.class.cast(object);
                String base64Email = user.getEmail();
                String email = new String(Base64.decodeBase64(base64Email), "UTF-8");
                user.setEmail(email);

            }
        }
    }

    @AfterReturning(value = "PointCut() && EnableDecode()", returning = "object")
    public void afterReturn(JoinPoint joinPoint, Object object)
    {
        if(object instanceof User)
        {
            User user = User.class.cast(object);
            String email = user.getEmail();
            String base64Email = new String(Base64.encodeBase64(email.getBytes(StandardCharsets.UTF_8)));
            user.setEmail(base64Email);
        }
    }


}
