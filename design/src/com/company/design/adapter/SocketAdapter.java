package com.company.design.adapter;

public class SocketAdapter implements Ele110V
{
    private Ele220V ele220V;

    public SocketAdapter(Ele220V ele220V)
    {
        this.ele220V = ele220V;
    }

    @Override
    public void powerOn()
    {
        ele220V.connect();
    }


}
