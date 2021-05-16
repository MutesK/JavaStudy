package DataStructure;

public class MyLinkedList<T> {
    private class Node<T>
    {
        T Data;
        Node<T> Next;

        public Node(T Data)
        {
            this.Data = Data;
            Next = null;
        }
    }

    private Node  head = null;
    private Node  tail = null;
    private long  size = 0;

    public MyLinkedList()
    {
    }

    void add(T element)
    {
        Node newNode = new Node(element);

        if(head == null || tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.Next = newNode;
            tail = newNode;
        }

        size++;
    }

    void erase(T element)
    {
        if(isEmpty())
            return;

        if(head.Data == element)
        {
            head = head.Next;
        }
        else
        {
            Node tempNode = head.Next;
            Node beforeNode = head;

            while(tempNode != null)
            {
                if(element == tempNode.Data)
                {
                    beforeNode.Next = null;
                    tempNode = null;
                    size--;
                    break;
                }

                tempNode = tempNode.Next;
                beforeNode = tempNode;
            }
        }
    }

    T Get(int index)
    {
        if(index >= size())
            throw new IndexOutOfBoundsException("LinkedList Out of Boundary");

        Node<T> search = head;
        for(int i=0; i<index; ++i)
        {
            search = search.Next;
        }

        return search.Data;
    }

    final long size()
    {
        return size;
    }

    final boolean isEmpty()
    {
        return size() == 0;
    }

}
