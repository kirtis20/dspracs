package pracs;
import java.util.*;

class InPostfix 
{
	// Function to determine the precedence of operators
	static int Prec(char ch)
	{
		// Switch statement to assign precedence values to operators
		switch(ch)
		{
		case '+':
			
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;		
		}
		// Return -1 for non-operators
		return -1;
	}
	
	// Function to convert infix expression to postfix expression
	static String infixToPostfix(String exp)
	{
		// Result string to store the postfix expression
		String result = new String("");
		// Stack to store operators
		Stack<Character> stack = new Stack<Character>();
		
		// Loop through each character in the input expression
		for(int i = 0; i < exp.length(); i++) 
		{
			char c = exp.charAt(i);
			
			// If the character is a letter or digit, append it to the result
			if(Character.isLetterOrDigit(c))
				result += c;
			// Handle opening parenthesis
			else if(c == '(')	
				stack.push(c);
			// Handle closing parenthesis
			else if(c ==')')
			{
				// Pop and append operators until an opening parenthesis is encountered
				while(!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				
				// Check for mismatched parentheses
				if(!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop(); // Pop the opening parenthesis
			}
			// Process operators
			else
			{
				// Pop and append operators with equal or higher precedence
				while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
				{
					// Check for invalid expression with opening parenthesis
					if(stack.peek() == '(')
						return "Invalid Expression";
					result += stack.pop();
				}
				// Push the current operator onto the stack
				stack.push(c);
			}
		}
		
		// Pop and append remaining operators from the stack
		while (!stack.isEmpty())
		{
			result += stack.pop();
		}
		
		// Return the final postfix expression
		return result;
	}
	
	public static void main(String args[])
	{
		// Scanner to take user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression:");
		String exp = sc.next();
		
		// Call the infixToPostfix function and print the result
		System.out.println(infixToPostfix(exp));
	}
}
