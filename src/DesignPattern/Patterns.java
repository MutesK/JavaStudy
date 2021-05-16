package DesignPattern;

class TestObject
{

}

class Singleton
{
    private static TestObject instance = null;

    private Singleton()
    {
    }

    public synchronized static TestObject GetInstance()
    {
        if(instance == null)
        {
            instance = new TestObject();
        }

        return instance;
    }
}

class AObject
{
    private AObject()
    {

    }

    private static class InnerInstanceClass
    {
        private static final AObject instance = new AObject();
    }

    public static AObject getInstance()
    {
        return InnerInstanceClass.instance;
    }
}

public class Patterns
{

}