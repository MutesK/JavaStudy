package ObjectCollaboration;

import java.util.Formatter;

/*
    Interface에서 정의한 변수는 final 선언과 같이 재정의가 불가능하다.
    Interface에서 Method를 final로 선언할 수 없다. (당연하다고 생각된다)
 */


abstract class Mobility
{
    protected int fee;
    protected int revenue = 0;
    protected int count = 0;

    final int GetFee()
    {
        return fee;
    }

    boolean Ride(Student s)
    {
        if(s.RideOn(this))
        {
            revenue += fee;
            count++;
            return true;
        }

        return false;
    }
};

class Bus extends Mobility
{
    public Bus(int fee)
    {
        this.fee = fee;
    }

    @Override
    boolean Ride(Student s) {
        if (!super.Ride(s))
            return false;

        /// Log

        return true;
    }
}

class Subway extends Mobility
{
    public Subway(int fee)
    {
        this.fee = fee;
    }
}

class Taxi extends Mobility
{
    String company;

    public Taxi(int fee, String company)
    {
        this.fee = fee;
        this.company = company;
    }

    @Override
    boolean Ride(Student s) {
        return super.Ride(s); /// Log
    }
}

class Student
{
    private String Name;
    private int Money;

    public Student(int Money, String name)
    {
        this.Money = Money;
        this.Name = name;
    }

    public boolean RideOn(Mobility mobility)
    {
        if(Money >= mobility.GetFee())
        {
            Money -= mobility.GetFee();
            System.out.printf("Ride on %s Cost is %d Remaining Money %d ", mobility.getClass().getName(),
                    mobility.GetFee(), Money);
            System.out.println();
            return true;
        }

        return false;
    }
}

public class Example
{
    public static void main(String[] Args)
    {
        Student s = new Student(10000, "A");
        Bus b1 = new Bus(100);
        Taxi t1 =new Taxi(2000, "미친회사");

        b1.Ride(s);
        t1.Ride(s);
    }
}
