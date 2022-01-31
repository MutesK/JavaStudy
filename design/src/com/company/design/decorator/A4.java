package com.company.design.decorator;

public class A4 extends AudiDecorator
{
    public A4(Audi audi, String nameModel)
    {
        super(audi, nameModel, 2000);
    }
}
