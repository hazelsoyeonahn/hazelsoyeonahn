package ex5_2;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class StudentEnrol {
	String name, address, birthday;
	
	public StudentEnrol(String name, String address, String birthday) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
	}
	
	public String toString() {
		return "name: "+this.name+" address: "+this.address+" birthday: "+this.birthday;
	}
	
	public static void main(String[] args) {
		boolean loop = true;
		int id = 1; //unique id for the students
		
		//decalring SortedMap object
		//key = hashcode with name
		//value = student information using studentEnrol constructor
		SortedMap<Integer, StudentEnrol> map = new TreeMap<Integer, StudentEnrol>();
		Scanner scan = new Scanner(System.in);
		
		//loop finishes when student want to stop enrolment
		while(loop) {
		System.out.println("Welcome to student enrollment!");
		System.out.println("Please type your information ");
		
		System.out.println("1. Your name: ");
		String name = scan.nextLine();
		
		System.out.println("2. Your address: ");
		String address = scan.nextLine();
		
		System.out.println("3. Your birthday: ");
		String birthday = scan.nextLine();
		
		System.out.println("Add more student? Y/N? ");
		String answer = scan.nextLine();	
		
		//generating sorted map
		map.put(id, new StudentEnrol(name, address, birthday));
		
		if(answer.equalsIgnoreCase("N"))
			loop = false;
		++id;
		}

		System.out.println("Type student id to get value: ");
		int getKey = scan.nextInt();
		
		System.out.println("id: "+getKey+map.get(getKey)+"\n");
		scan.close();
		
		//iterate key and value
		System.out.println("Print all of the student's information");
		map.keySet().forEach(key ->{
			System.out.println("key: "+key + " -> "+"value: " + map.get(key));
		});
	}
	
	
}

