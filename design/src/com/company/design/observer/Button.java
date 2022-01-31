package com.company.design.observer;

public class Button
{
    private String name;
    private IButtonListener buttonListener;

    public Button(String name)
    {
        this.name = name;
    }

    public void click(String message)
    {
        buttonListener.OnClickEvent(message);
    }

    public void addButtonListener(IButtonListener Listener)
    {
        buttonListener = Listener;
    }

}
