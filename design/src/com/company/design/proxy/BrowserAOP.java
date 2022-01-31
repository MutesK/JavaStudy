package com.company.design.proxy;

public class BrowserAOP implements IBrowser
{
    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public BrowserAOP(String url, Runnable before, Runnable after)
    {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show()
    {
        before.run();

        try
        {
            if (html == null)
            {
                System.out.println("Browser loading html from : " + url);
                html = new Html(url);
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        after.run();
        {
            System.out.println("Browser Using Cache : " + url);
        }


        return html;
    }
}
