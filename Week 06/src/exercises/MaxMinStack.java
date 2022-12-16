package exercises;
import java.util.Stack;

public class MaxMinStack {
	static class StackMax{
		static Stack<Integer> mainStack = new Stack<Integer>();
		static Stack<Integer> maxStack = new Stack<Integer>();
		static Stack<Integer> minStack = new Stack<Integer>();
		
		static void push(int x) {
			mainStack.push(x);
			if(mainStack.size() == 1) {
				maxStack.push(x);
				minStack.push(x);
				return;
			}
			
			if(x > maxStack.peek()) {
				maxStack.push(x);
			}
			else {
				maxStack.push(maxStack.peek());
			}
			
			if(x < minStack.peek()) {
				minStack.push(x);
			}
			else {
				minStack.push(minStack.peek());
			}
		}
		
		static int getMax() {
			return maxStack.peek();
		}
		
		static int getMin() {
			return minStack.peek();		
		}
		
		static void pop() {
			mainStack.pop();
			maxStack.pop();
			minStack.pop();
		}
	}
	public static void main(String[] args) {
		StackMax stack = new StackMax();
		stack.push(66);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.push(5);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.push(17);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.push(29);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.push(90);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.push(1);
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
	}
}
