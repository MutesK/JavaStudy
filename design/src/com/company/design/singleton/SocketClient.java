package com.company.design.singleton;

public class SocketClient
{
    private static SocketClient socketClient;

    private SocketClient()
    {
    }

    public static SocketClient GetInstance()
    {
        if(socketClient == null)
        {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect()
    {
        System.out.println("connect");
    }
}
