package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

class Pair<K, V>  extends Object
{
    private K Key;
    private V Value;

    public Pair(K Key, V Value)
    {
        this.Key = Key;
        this.Value = Value;
    }

    public final K getFirst()
    {
        return Key;
    }

    public final V getSecond()
    {
        return Value;
    }

    @Override
    public int hashCode() {
        return Key.hashCode() + Value.hashCode();
    }

}

interface IMyHash<T>
{
    void add(T object);
    void remove(T object);
    long size();
}

public class MyHashSet<T> implements IMyHash<T>
{
    private static class Hash
    {
        public static long GetHash(Object object)
        {
            return object.hashCode();
        }
    }

    private ArrayList<LinkedList<T>> BucketLists;
    private long HashAllocSize = 1000;
    private long UseCount = 0;
    public MyHashSet()
    {
        BucketLists = new ArrayList<>();

        for(int i=0; i<HashAllocSize; ++i)
        {
            BucketLists.set(i, new LinkedList<T>());
        }
    }

    private LinkedList<T> GetBucketList(T object)
    {
        int hash = (int) (Hash.GetHash(object) % HashAllocSize);
        var BucketList = BucketLists.get(hash);

        return BucketList;
    }

    public void add(T object)
    {
        var BucketList = GetBucketList(object);
        if(BucketList.size() > 0 )
        {
            System.out.println("Collision Dected");
        }

        BucketList.add(object);

        ++UseCount;
    }

    public  void remove(T object)
    {
        var BucketList = GetBucketList(object);
        if(BucketList.size() > 0 )
        {
            System.out.println("Collision Dected");
        }

        BucketList.remove(object);
    }

    public  final long size()
    {
        return UseCount;
    }
}

class MashMap<K, V> implements IMyHash<Pair<K, V>>
{
    private MyHashSet<Pair<K, V>>  HashSet;

    public MashMap()
    {
        HashSet = new MyHashSet<>();
    }

    @Override
    public void add(Pair<K, V> object) {
        HashSet.add(object);
    }

    @Override
    public void remove(Pair<K, V> object) {
        HashSet.remove(object);
    }

    @Override
    public long size() {
        return HashSet.size();
    }
}
