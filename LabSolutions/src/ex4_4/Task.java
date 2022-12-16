package ex4_4;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Task<E> extends PriorityQueue{
	
	static PriorityQueue<Integer> elements = new Task<Integer>();
	
	//add integer element to the queue
	public static void enqueue(int numbers) {
		elements.add(numbers);
	}
	
	//dequeue minimum number of the queue
	//the priority queue will organise the numbers already
	//therefore the minimum number will always be on top of the queue
	static public int dequeueMin() {
		return elements.poll();
	}
	
	//the priority queue will always put minimum numbers 
	//on the head of the queue
	static public int findMin() {
		return elements.peek();
	}
	
	public static void main(String[] args) {
		
		enqueue(5);
		enqueue(2);
		enqueue(1);
		enqueue(9);
		enqueue(7);
		
		System.out.println("Numbers added: "+elements);
		System.out.println("dequeueMin: "+dequeueMin());
		System.out.println("findMin: "+findMin());
	}
}
