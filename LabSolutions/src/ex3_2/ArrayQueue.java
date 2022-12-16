package ex3_2;

import java.util.Scanner;

public class ArrayQueue {
	private int[] queue;
	private int size, front, rear;
	private int CAPACITY = 3; //length of the array
	
	//default constructor
	public ArrayQueue() {
		queue = new int[CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	//insert elements
	public void enQueue(int data) {
		if(size == CAPACITY) {
			expandCapacity();}
		size++;
		queue[rear] = data;
		rear = (rear+1)%CAPACITY;
	}
	
	//remove front element
	public void deQueue() {
		if(size == 0)
			System.out.println("Queue is empty");
		else {
			size--;
			int data = queue[(front%CAPACITY)];
			for(int i=0; i<size; ++i) {
				queue[i] = queue[i+1];
			}
			front = (front + 1) % CAPACITY;
			System.out.println("Element Deleted is " +data);
		}
	}
	
	//check if queue is empty
	public boolean isEmpty() {
		return(size==0);
	}
	
	public String toString() {
		String result = "[";
		for(int i = 0; i<size; i++) {
			result += Integer.toString(queue[i]);
			if(i<size-1) {
				result += ",";
			}
		}
		result += "]";
		return result;
		}
	//expand capacity if needed
	public void expandCapacity() {
		int[] temp = new int[queue.length];
		for(int i = 0;i<queue.length; i++) {
			temp[i] = queue[i];
		}
		queue = new int[CAPACITY * 2];
		for(int i= 0; i<temp.length; i++) {
			queue[i] = temp[i];
		}
		CAPACITY += CAPACITY;
	}
	
	//main
	public static void main(String[]args) {
ArrayQueue arrayQueue = new ArrayQueue();
		Scanner scan = new Scanner(System.in);
		int userInput;
		
		while(true) {
			System.out.println("1. Add element");
			System.out.println("2. Delete first element");
			System.out.println("3. Show queue");
			System.out.println("4. Exit");
			userInput = scan.nextInt();
			
			if(userInput ==1) {
				System.out.println("Enter the elemente:");
				userInput = scan.nextInt();
				arrayQueue.enQueue(userInput);
			}
			else if(userInput ==2) {
				arrayQueue.deQueue();
			}
			else if(userInput ==3) {
				System.out.println(arrayQueue.toString());
			}
			else if(userInput ==4) {
				System.exit(0);
			}
			else {
				System.out.println("Wrong input");
			}
		}
	}

}

