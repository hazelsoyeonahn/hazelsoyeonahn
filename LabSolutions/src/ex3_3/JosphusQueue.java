package ex3_3;

import java.util.Scanner;

public class JosphusQueue {
	
	public static void main(String[] args) {
		int numPeople, gap, counter;
		
		Queue<Integer> queue = new Queue<Integer>();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of soldiers: ");
		numPeople = in.nextInt();
		in.nextLine();
		
		System.out.println("Enter the gap between soldiers: ");
		
		gap = in.nextInt();
		
		for(int count=1; count <= numPeople; count++) {
			queue.enqueue(count);
		}
		counter = gap - 1;
		System.out.println("The order is");
		
		//treating the list as circular, remove every nth
		//element until the list is empty
		while(!(queue.isEmpty())) {
			for(int i=0; i<counter; ++i) {
				//remove element from front end
				int ele = queue.dequeue();
				//add element to the rear of queue
				queue.enqueue(ele);
			}
			
			System.out.println(queue.dequeue());
		}
		
	}
}