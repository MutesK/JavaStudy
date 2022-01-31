package com.company.design.proxy;

public class BrowserProxy implements IBrowser
{
    private String url;
    private Html html;

    public BrowserProxy(String url)
    {
        this.url = url;
    }

    @Override
    public Html show()
    {
        if(html == null)
        {
            System.out.println("Browser loading html from : " + url);
            html = new Html(url);
        }
        else
        {
            System.out.println("Browser Using Cache : " + url);
        }
        return html;
    }
}
