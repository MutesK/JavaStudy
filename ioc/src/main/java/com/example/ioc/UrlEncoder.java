package com.example.ioc;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component // Componenet Singleton
public class UrlEncoder implements IEncoder
{
    @Override
    public String enocde(String message)
    {
        try
        {
            return URLEncoder.encode(message, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
