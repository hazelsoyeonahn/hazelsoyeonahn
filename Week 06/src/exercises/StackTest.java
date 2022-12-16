package exercises;
import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;

public class StackTest {
	
	public void mainipulateStack() {
		Stack stack = new Stack();
		
		System.out.println("Enter a number for the stack(or type quit to manipulate stacks)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		while(!input.equals("quit")) {
			stack.push(Integer.parseInt(input));
			
			input = scanner.next();
		}
		
		Iterator<Integer> iterator = stack.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		StackTest stacks = new StackTest();
		
		stacks.mainipulateStack();
	}
}
