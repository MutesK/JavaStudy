package Grammer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class RefObject
{

};

class TestObject
{
    private class InnerClass
    {

    };
    public String A;
    public RefObject Obj;

    TestObject(String a)
    {
        A = a;
        Obj = new RefObject();
    }
}

class ThisCaller
{
    public ThisCaller(int temp)
    {
        System.out.println("Called Custom Ctor");
    }

    public ThisCaller()
    {
        this(1); // Only Called Ctor first Line this(/* arguments */)

        System.out.println("Called Default Ctor");
    }

    public void DoTest()
    {
        // this(1); not work
    }
}

public class Test {
    public static void SwapTest(Integer a, Integer b)
    {
        System.out.println("Call in SwapTest Integer Reference");
        System.out.println(a.getClass().getName() + "@" + a.hashCode() );
        System.out.println(a.getClass().getName() + "@" + a.hashCode() );

        Integer t;
        t = a;
        a = b;
        b = a;
    }

    public static void StringBufferAndStringBuilderTest()
    {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(() -> {
            for(int i=0; i<10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            for(int i=0; i<10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);

                System.out.println("StringBuffer.length: "+ stringBuffer.length());
                System.out.println("StringBuilder.length: "+ stringBuilder.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void IterTest()
    {
        ArrayList<Integer> List = new ArrayList<>();

        List.add(4);
        List.add(4);
        List.add(4);
        List.add(4);
        List.add(4);

        for(Integer value : List)
        {
            System.out.println(value);
        }

        for(Iterator iter = List.iterator(); iter.hasNext(); )
        {
            System.out.println(iter.next());
        }
    }

    public static void ArrayCopy()
    {
        int[] Raw = new int[1000];
        int[] CopyedArray = null;

       System.arraycopy(Raw, 0, CopyedArray, 0, 1000);
    }

    public static void main(String[] args)
    {
        TestObject object = new TestObject("A");
        TestObject copyed_object = object;


        System.out.println(object);
        System.out.println(copyed_object);

        System.out.println(object.A);
        System.out.println(copyed_object.A);

        System.out.println(object.Obj);
        System.out.println(copyed_object.Obj);

        Integer a =4, b = 2;

        System.out.println("Call before Interger Referneces");
        System.out.println(a.getClass().getName() + "@" + a.hashCode());
        System.out.println(a.getClass().getName() + "@" + a.hashCode());

        SwapTest(a, b);


        StringBufferAndStringBuilderTest();
    }


}
