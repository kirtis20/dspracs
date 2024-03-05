package pracs;

import java.util.*;

class LLNode
{
    private int data;
    private LLNode next;

    public int getData() 
    {
        return data;
    }
    public void setData(int data) 
    {
        this.data = data;
    }

    public LLNode getNext() 
    {
        return next;
    }
    public void setNext(LLNode next) 
    {
        this.next = next;
    }

    public LLNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class LLDemo 
{
    public static void main(String[] args)
    {
        LLNode head = null;
        LLNode p = null;
        LLNode q = null;

        LLNode node1 = new LLNode(20);
        LLNode node2 = new LLNode(30);
        LLNode node3 = new LLNode(40);

        node2.setNext(node3);
        node1.setNext(node2);
        head = node1;
        p = node1;
        q = node1;

        while(p != null)
        {
            q = p;
            System.out.print("-->" + q.getData());
            p = p.getNext();            
        }
    }
}
