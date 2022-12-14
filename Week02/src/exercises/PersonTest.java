package exercises;

import java.util.Scanner;

public class PersonTest {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Person person = new Person();
		
		System.out.println("Please enter the person's age:");
		person.age = scan.nextInt();
		
		System.out.println("Please enter the person's weight:");
		person.weight = scan.nextDouble();
		
		System.out.println("Is the person a student (true/false):");
		person.student = scan.nextBoolean();
		
		System.out.println("Please enter the person's gender (M/F):");
		person.gender = scan.next().charAt(0);
		
		System.out.println("Person: age: "+person.age+" weight: "+person.weight+" retired: "+person.student+" gender: "+person.gender+"");
	}

}
