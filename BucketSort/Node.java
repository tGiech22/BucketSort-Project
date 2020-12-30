public class Node
{
    private Object data; 
    private Node next;
    /*** Constructor for objects of class Node */
    public Node()
    {
        data = null; // set default values
        next = null;
    }

    public Node(Object x)
    {
        data = x;
        next = null;
    }

    public void setNext(Node n)
    {
        next = n;
    }

    public void setMyValue(Object x)
    {
        data = x;
    }
    
    public Node getNext()
    {
        return next;
    }

    public String toString()
    {
        if(data == null)
        {
            return "null";
        }
        return data.toString();
    }

    public Object getMyValue()
    {
        return data;
    }
}

