package pracs;

import java.util.Scanner;

class MyStack 
{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack(int s)
	{
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long j)
	{
		stackArray[++top] = j;
	}
	
	public long pop()
	{
		long y = stackArray[top];
		--top;
		return y;
	}
	
	public long peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		if (top == -1)
			return true;
		return false;
	}
	
	public boolean isFull()
	{
		return (top == maxSize - 1);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("******** Stack Demo *******");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total stack elements: ");
		int max = sc.nextInt();
		MyStack st = new MyStack(max);
		
		for(int i = 0; i < max; i++)
		{
			System.out.println("Enter the element " + (i + 1));
			long v = sc.nextLong();
			st.push(v);
		}
		
		while (!st.isEmpty())
		{
			long value = st.pop();
			System.out.println(value);
			System.out.println(" ");
		}
		System.out.println("");
	}
}
