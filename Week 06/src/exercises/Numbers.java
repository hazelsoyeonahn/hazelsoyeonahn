package exercises;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
	private ArrayList<Integer> list;
	
	//initializing the list
	public Numbers(){
		list = new ArrayList<Integer>();
	}
	
	//add the numbers to the list
	public void addNumber(Integer i) {
		list.add(i);
	}
	
	//clear the list
	public void clear() {
		list.clear();
	}
	
	//print the whole list until it's empty
	public void printList() {
		if(list.size() != 0) {
			System.out.println("List: ");
			for (int i = 0; i<list.size(); ++i) {
				System.out.print(list.get(i)+" ");
			}
		}
		else {
			System.out.println("The list is empty");
		}
	}
	
	//get minimum number in the list
	public Integer min() {
		return Collections.min(list);
	}
	
	//get maximum number in the list
	public Integer max() {
		return Collections.max(list);
	}
	
	public static void main(String[] args) {
		Numbers number = new Numbers();
		
		//add numbers to the list
		number.addNumber(4);
		number.addNumber(24);
		number.addNumber(66);
		number.addNumber(7);
		number.addNumber(59);
		number.addNumber(1);
		number.addNumber(30);
		number.addNumber(56);
		number.addNumber(48);
		number.addNumber(99);
		
		//print the list
		number.printList();
		System.out.println("\n");
		
		//print the minimum number
		System.out.println("Minimum: "+number.min());
		
		//print the maximum number
		System.out.println("Maximum: "+number.max());
		
		
		System.out.println("List clearing in progress...");
		//clear the list
		number.clear();
		
		number.printList();
		
	}

}
