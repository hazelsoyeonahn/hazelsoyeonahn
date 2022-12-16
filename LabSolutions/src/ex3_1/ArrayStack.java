package ex3_1;
/**
 * A class that implements a stack collection using an
 * array as the underlying data structure
 * @author hazelsoyeonahn
 */

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayStack <E> implements StackADT<E> {
	private final int INITIAL_CAPACITY = 20;
	protected int numElements;
	protected E[] elements;
	
	// default constructor that creates a new stack
	// that is initially empty
	public ArrayStack() {
		numElements = 0;
		elements = (E[])(new Object[INITIAL_CAPACITY]); //unchecked
	}
	
	// constructor for creating a new stack which
	// initially holds the elemtns in the collection c
	public ArrayStack(Collection<? extends E> c) {
		this();
		for(E element : c) 
			push(element);
	}
	
	// Adds one element to the top of this stack
	public void push(E element) {
		if (numElements >= elements.length)
			expandCapacity();
			moveRight();
		elements[0] = element;
		numElements++;
	}
	
	//removes and returns the top element from this stack
	public E pop() throws NoSuchElementException
	{
		if (numElements > 0) {
			E topElement = elements[0];
			moveLeft();
			//elements[numElements-1] = null;
			numElements--;
			return topElement;
		}
		else
			throw new NoSuchElementException();
	}
	
	//returns without removing the top element of this stack
	public E peek() throws NoSuchElementException{
		if (numElements > 0)
			return elements[0];
		else
			throw new NoSuchElementException();
	}
	
	//return true if this stack contains no elements
	public boolean isEmpty() {
		return (numElements==0);
	}
	
	//return the number of elements in this stack
	public int size() {
		return numElements;
	}
	
	//return a string represantation of the stack from top to bottom
	public String toString() {
		String output = "[";
		for(int i=numElements-1; i>=0; i--) {
			output += elements[i];
				if(i>0) {
					output += ",";
				}
		}
		return output;
	}
	
	//helper method which doubles the current size of the array
	private void expandCapacity() {
		E[] largerArray = (E[])(new Object[elements.length*2]); //unchecked
		//copy the elements array to the largerArray
		for(int i=0; i<numElements; i++) 
			largerArray[i] = elements[i];
		elements = largerArray;
	}
	
	private void moveLeft() {
		for(int i = 0; i<numElements-1; i++) {
			elements[i] = elements[i+1];
		}
	}
	
	private void moveRight() {
		for(int i = numElements+1; i>0; i--) {
			elements[i] = elements[i-1];
		}
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		int userInput, result;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Choose one");
			System.out.println("1.Push 2.Pop 3.Peek 4.Result 5.Exit");
			userInput = scan.nextInt();
			
			if(userInput == 1) {
				System.out.println("Enter the number you want to push");
				userInput = scan.nextInt();
				stack.push(userInput);
			}
			else if(userInput == 2)try{
				result = stack.pop();
				System.out.println(result+" is poped");
				}catch(NoSuchElementException e){
					System.out.println("Stack is empty");
				}
			else if(userInput == 3)try {
				result = stack.peek();
				System.out.println(result+" is peeked");
			}catch(NoSuchElementException e){
				System.out.println("Stack is empty");
			}
			
			else if(userInput == 4) {
				System.out.println(stack);
			}
			
			else if(userInput == 5) {
				System.err.println("Invalid choice");
				System.exit(0);
			}
		}
	}

}

