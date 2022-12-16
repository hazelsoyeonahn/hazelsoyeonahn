package exercises;

import java.util.Iterator;
import java.util.Stack;
import java.util.Scanner;

public class Brackets {
	public boolean manipulateBracket() {
		Scanner scanner = new Scanner(System.in);
		Stack stack = new Stack();
		String firstChar;
		String secondChar;
		boolean quit = true;
		
		System.out.println("Enter brackets(or type quit to check if it's balanced");
		String input = scanner.next();
		
		while(!input.equals("quit")) {
			stack.push(input);
			
			input = scanner.next();
		}
		
		Iterator<Integer> iterator = stack.iterator();
		
		while(iterator.hasNext()) {
			secondChar = stack.pop().toString();
			firstChar = stack.pop().toString();
			
			if(firstChar.equals("(")||secondChar.equals(")")){
				System.out.println(firstChar+" "+secondChar);
			}
			else if(firstChar.equals("{")||secondChar.equals("}")){
				System.out.println(firstChar+" "+secondChar);
			}
			else if(firstChar.equals("[")||secondChar.equals("]")){
				System.out.println(firstChar+" "+secondChar);
			}
		
			else {
				quit = false;
			}
		}
		return quit;
	}
	
	public static void main(String[] args) {
		Brackets bracket = new Brackets();
		
		boolean result;
		result = bracket.manipulateBracket();
		
		if(result == true) {
			System.out.println("True");
		}
		
		else {
			System.out.println("False");
		}
	}

}
