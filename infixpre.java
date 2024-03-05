package pracs;
import java.util.*;

class InfixToPrefix 
{
    static int Prec(char ch)
    {
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
        return -1;
    }

    static String reverseString(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static String infixToPrefix(String exp)
    {
        String reversedInfix = reverseString(exp);
        StringBuilder result = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < reversedInfix.length(); i++) 
        {
            char c = reversedInfix.charAt(i);

            if(Character.isLetterOrDigit(c))
                result.append(c);
            else if(c ==')')  
                stack.push(c);
            else if(c =='(')
            {
                while(!stack.isEmpty() && stack.peek() != ')')
                    result.append(stack.pop());

                if(!stack.isEmpty() && stack.peek() != ')')
                    return "Invalid Expression";
                else
                    stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && Prec(c) < Prec(stack.peek()))
                {
                    if(stack.peek() == ')')
                        return "Invalid Expression";
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
        {
            result.append(stack.pop());
        }

        return reverseString(result.toString());
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix expression:");
        String exp = sc.next();
        System.out.println(infixToPrefix(exp));
    }
}
