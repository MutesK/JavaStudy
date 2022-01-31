package com.company.design.decorator;

public class AudiDecorator implements ICar
{

    protected Audi audi;
    protected String modelName;
    protected int modelPrice;

    AudiDecorator(Audi audi, String modelName, int modelPrice)
    {
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice()
    {
        return this.audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice()
    {
        System.out.println(modelName + "의 가격은 " + modelPrice + "입니다.");
    }
}
