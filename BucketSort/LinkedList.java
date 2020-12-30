import java.util.*;
public class LinkedList
{
    private Node front; // first value in the list
    public LinkedList() // default constructor: empty list
    { 
        front = null; 
    }

    public LinkedList(int[] arrayInt)
    {
        for(int i = 0;i < arrayInt.length; i++)
        {
            add(arrayInt[i]);
        }
    }
    
    // post: returns comma-separated, bracketed version of list
    public String toString()
    {
        if(front == null) // empty or hasn't initialized
        { 
            return "[]";
        }
        else // empty is not empty
        { 
            String result = "[" + front;
            Node current = front.getNext(); // next data for the first node
            
            while(current != null)
            {
                result += "," + current;
                current = current.getNext(); // shifting to the next node repeatedly
            }
            
            return result + "]"; // the end of the list
        }        
    }

    // post: appends the given value to the end of the list
    public void add(int data)
    {
        if(front == null) // empty list then create a new node for the head
        { 
            front = new Node(data);
        }
        else
        {
            Node current = front;
            
            while(current.getNext() != null)
            {
                current = current.getNext();
            }
            
            current.setNext(new Node(data));
        }
    }
    
    public Node getFront()
    {
        return front;
    }
    public void clear()
    {
        front = null;
    }
}
