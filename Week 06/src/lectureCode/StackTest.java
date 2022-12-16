package lectureCode;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(2);
		stack.push(8);
		int top = stack.peek();
		stack.pop();
		stack.push(10);
		stack.push(6);
		Integer i = stack.pop();
		System.out.println(i);
		

	}

}
