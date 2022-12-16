package exercises;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;

public class QueueAlgorithms {
	
	public static Queue<Integer> reverse(Queue <Integer>numberQ){
		
		//utilize stack
		Stack<Integer> stack = new Stack<Integer>();
		//where reversed stack will be stored
		Queue<Integer> reverseQ = new LinkedList<>();
		
		//save the elements to the stack
		for(Integer item : numberQ) {
			stack.push(item);
		}
		
		//then pop the elements to add it to queue
		Integer stackSize = stack.size();
		for(Integer x = 0; x <stackSize; ++x) {
			reverseQ.add(stack.pop());
		}
		
		return reverseQ;
	}
	
	public static Boolean isPalindrome(Queue<Integer>NumberQ) {
		
		//initialized return boolean
		Boolean iPalindrome = true;
		
		//reverse the queue
		Queue<Integer> reverseQ = reverse(NumberQ);
		
		//accessing through iterator
		Iterator iterateNumberQ = NumberQ.iterator();
		Iterator iterateReverseQ = reverseQ.iterator();
		
		//getting the values for queue
		while(iterateNumberQ.hasNext()) {
			Integer iNumberQ = (Integer)iterateNumberQ.next();
			Integer iReverseQ = (Integer)iterateReverseQ.next();
			
			//comparing the elements
			if(iNumberQ != iReverseQ) {
				iPalindrome = false;
				break;
			}
		}
		return iPalindrome;	
	}
	
	//returning minimum value
	public static Integer min(Queue<Integer>NumberQ) {
		
		//accessing through iterator
		Iterator iterateNumberQ = NumberQ.iterator();
		
		Integer min = NumberQ.peek();
		while(iterateNumberQ.hasNext()) {
			Integer iNumberQ = (Integer)iterateNumberQ.next();
			//compare
			if(iNumberQ < min) {
				min = iNumberQ;
			}
		}
		
		return min;
	}
	
	//returning maximum value
	public static Integer max(Queue<Integer>NumberQ) {
		
		//accessing through iterator
		Iterator iterateNumberQ = NumberQ.iterator();
		
		Integer max = NumberQ.peek();
		while(iterateNumberQ.hasNext()) {
			Integer iNumberQ = (Integer)iterateNumberQ.next();
			//compare
			if(iNumberQ > max) {
				max = iNumberQ;
			}
		}
		return max;
	}
	
	//main in this class
	public static void main(String[] args) {
		
		Queue<Integer> NreversedQ = new LinkedList<>();
		
		NreversedQ.add(17);
		NreversedQ.add(52);
		NreversedQ.add(26);
		NreversedQ.add(1);
		NreversedQ.add(97);
		NreversedQ.add(67);
		NreversedQ.add(88);
		NreversedQ.add(42);
		NreversedQ.add(15);
		NreversedQ.add(72);
		NreversedQ.add(90);
		
		//print out the queue
		System.out.println("Queue: "+NreversedQ);
		
		
		//print out the reversed queue
		Queue<Integer> ReversedQ = reverse(NreversedQ);
		System.out.println("Reversed Queue: "+ReversedQ);

		//Check if palindrome
		System.out.println("Palindrome: "+ isPalindrome(NreversedQ));
		
		//print out the minimum
		System.out.println("Minimum: "+ min(NreversedQ));
		
		//print out the maximum
		System.out.println("Maximum: "+ max(NreversedQ));
	}

}
