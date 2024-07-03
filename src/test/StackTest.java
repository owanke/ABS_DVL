package test;
import implementierung.*;

public class StackTest
{

    public static void main(String[] args)
    {
       Stack stack = new Stack();
       stack.push(4);
       stack.push(-2);
       stack.push(6);
       int size=stack.getSize();
       int result1 = stack.pop();
       int result2 = stack.top();
       int result3 = stack.top();
       
       System.out.println("no problems");
       
       

    }

}
