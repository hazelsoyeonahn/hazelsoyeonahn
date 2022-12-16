package ex3_3;

import java.util.LinkedList;
//3.3
public class Queue<T> {
	 private LinkedList<T> list;
	 private int front;
	 private int rear;
	 
	 public Queue() {
		 list = new LinkedList<T>();
		 front = 0;
		 rear = 0;
	 }
	 
	 public void enqueue(T item) {
		 list.addLast(item);
		 rear++;
	 }
	 
	 public T dequeue() {
		 T item;
		 
		 if(isEmpty()) {
			 System.out.print("Empty!!");
			 return null;
		 }
		 else {
			 item = list.removeFirst();
			 front++;
		 }
		 return item;
	 }
	 
	 public T getFirst() {
		 T item = null;
		 if(!isEmpty())
			 item = list.getFirst();
		 return item;
	 }
	 
	 public T getLast() {
		 T item = null;
		 if(!isEmpty()) {
			 item = list.getLast();
		 }
		 return item;
	 }
	 
	 public boolean isEmpty() {
		 return front == rear;
	 }
	 
	 public int QueueSize() {
		 return list.size();
	 }
	 
	 public void display() {
		 for(T e: list)
			 System.out.println(e);
		 }
}