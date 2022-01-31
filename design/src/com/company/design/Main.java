package com.company.design;

import com.company.design.adapter.AirConditioner;
import com.company.design.adapter.Ele110V;
import com.company.design.adapter.HairDryer;
import com.company.design.adapter.SocketAdapter;
import com.company.design.decorator.Audi;
import com.company.design.decorator.ICar;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserAOP;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        /*
        // Adapter Test code
        HairDryer dryer = new HairDryer();
        connect(dryer);

        AirConditioner conditioner = new AirConditioner();
        connect(new SocketAdapter(conditioner));
        */

        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();


        // Proxy Pattern
        IBrowser proxy = new BrowserProxy("www.naver.com");

        proxy.show();
        proxy.show();
        proxy.show();
        proxy.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopProxy = new BrowserAOP("www.naver.com",
                () -> {
                    System.out.println("Before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopProxy.show();
        System.out.println("Loading Time : " + end.get());

        aopProxy.show();
        System.out.println("Loading Time : " + end.get());
        */

        ICar audi = new Audi(1000);
        audi.showPrice();

    }

    public static void connect(Ele110V device)
    {
        device.powerOn();
    }
}
