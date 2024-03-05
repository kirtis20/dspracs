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

public class LLDemo2 
{
	static LLNode createLL(LLNode head, int data)
	{
		LLNode h = head;
		LLNode p = h;
		LLNode q = h;
		LLNode newNode = null;

		if(h == null)
		{
			h = new LLNode(data);
		}
		else
		{
			while(p != null)
			{
				q = p;
	 			p = p.getNext();		
			}
			newNode = new LLNode(data);
			q.setNext(newNode);
		}

		return h;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		int n = sc.nextInt();
		LLNode head = null;
		LLNode p = null;
		LLNode q = null;

		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter the data for node " + (i + 1) + ": ");
			int data = sc.nextInt();
			LLNode a = createLL(head, data);

			if(i == 0)
			{
				head = a;
				p = a;
				q = a;
			}
		}

		while(p != null)
		{
			q = p;
			System.out.print("-->" + q.getData());
			p = p.getNext();
		}
	}
}
