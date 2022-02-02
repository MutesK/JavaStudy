package com.example.ioc;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component // 객체로 관리한다.
public class Base64Encoder implements IEncoder
{
    @Override
    public String enocde(String message)
    {
        return Base64.getEncoder().encodeToString(message.getBytes(StandardCharsets.UTF_8));
    }
}
