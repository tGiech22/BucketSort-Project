/**
 * Write a description of class bucketSortLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class BucketSortLL
{
    public static void main(){
        int[] numbers = {105, 87142, 95, 12987120, 7194, 9, 3 ,5, 124325, 1234, 212, 9238};       
        LinkedList list = new LinkedList(numbers);  
        /*Scanner input = new Scanner(System.in);
        // System.out.print("size of the list:");
        // int size = input.nextInt();
        for(int i = 1;i <= size;i++){
        list.add(input.nextInt());
        }*/
        Node buckets[] = new Node[10];
        
        for(int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new Node();
        }
                
        bucketSort(list, buckets, numbers.length);
    }

    public static void bucketSort(LinkedList list, Node buckets[], int length)
    {
        int places = 1;
        
        while(!(firstRowFull(buckets[0], length))) // stop when the first row is full, which is increasing order
        { 
            bucketToList(list, buckets);// put bucket into array
            
            System.out.println("list after gathering process:"+ list);
            
            listToBucket(list,places,buckets); // put the list values into bucket
            
            places *= 10;  
            
            printBucket(buckets);
            System.out.println();
        }        
    }
    
    //distributing process
    public static void listToBucket(LinkedList list, int places, Node buckets[])
    {
        Node curr = list.getFront();
        
        while(curr != null)  // traverse the bucket Node
        {  
            int digit = ((int) curr.getMyValue() / places) % 10; // get the digit 
            
            if(buckets[digit].getMyValue() == null) // first insertion when it is empty
            { 
                buckets[digit] = new Node(curr.getMyValue());
            }
            else
            {
                Node base = buckets[digit];
                
                while(base.getNext() != null)
                {
                    base = base.getNext();
                }
                
                base.setNext(new Node(curr.getMyValue()));                
            }           
            
            curr = curr.getNext();
        }
        
        list.clear(); // empty the list after distributing        
    }
    
    //gathering process
    public static void bucketToList(LinkedList list, Node buckets[])
    {
        for(int i = 0; i <= 9; i++)
        {
            Node start = buckets[i];
            
            while(start != null && start.getMyValue() != null)
            {
                list.add((int)start.getMyValue()); // add to the list when it found one
                
                start = start.getNext();
            }
            
            buckets[i].setMyValue(null); // empty the row of the bucket
            buckets[i].setNext(null);
        }
    }
    
    // return true if it first row is full
    // return false if fitst row is not full
    public static boolean firstRowFull(Node firstRow, int ListSize)
    {
        int NodeSize = 0;
        Node curr = firstRow;
        
        while(curr != null && curr.getMyValue() != null)
        {
            NodeSize++;
            curr = curr.getNext();
        }
        
        return NodeSize == ListSize;
    }
    
    // print out the entire bucket 
    public static void printBucket(Node buckets[])
    {
        System.out.println();
        for(int i = 0; i<=9; i++) // travserse the the base 0 - 9 
        { 
            Node base = buckets[i];
            
            if(base.getMyValue() == null) // empty list
            { 
                System.out.println(base); // which prints out null
            }
            else // one or more than one node exists
            { 
                System.out.print(base.getMyValue());
                base = base.getNext();
                
                while(base != null) // traverse node
                { 
                    System.out.print(","+ (int) base.getMyValue());
                    
                    base = base.getNext();
                }
                
                System.out.println("");
            }
        }
    }
}
