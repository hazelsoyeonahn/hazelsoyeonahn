package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomerPayRoll {
	private static ArrayList<Customer> alist;
	
	//initializing empty list
	public CustomerPayRoll() {
		alist = new ArrayList<>();
	}

	public static ArrayList<Customer> getAlist() {
		return alist;
	}
	
	public static ArrayList<Customer> inputCustomer(){
		Scanner scanner = new Scanner(System.in);
		String name;
		int salary;
		
		while(true) {
			//scanning customer's information
			System.out.println("Enter name:");
			name = scanner.next();
			
			if(name.equalsIgnoreCase("stop")) {
				break;
			}
			
			System.out.println("Enter Salary:");
			salary = scanner.nextInt();
			
			//add customer to arrayList
			alist.add(new Customer(name, salary));
		}
		Collections.sort(alist);
		scanner.close();
		return alist;
	}
	
}
