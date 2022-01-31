package com.company.design.adapter;

public class AirConditioner implements Ele220V
{
    @Override
    public void connect()
    {
        System.out.println("에어컨 220볼트");
    }
}
