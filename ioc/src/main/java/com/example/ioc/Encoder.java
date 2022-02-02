package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;

public class Encoder
{
    private IEncoder iencoder;

    public Encoder(@Qualifier("base64Encoder") IEncoder iEncoder)   // 기본으로 UrlEncoder들어감
    {
        setEndcoder(iEncoder);
    }

    public void setEndcoder(IEncoder iencoder)
    {
        this.iencoder = iencoder;
    }

    public String encode(String message)
    {
        return iencoder.enocde(message);
    }
}
