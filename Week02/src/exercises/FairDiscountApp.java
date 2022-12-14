package exercises;

import java.util.Scanner;

public class FairDiscountApp {
	
	
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
		
		System.out.println("Person: age: "+person.age+" weight: "+person.weight+" student? "+person.student+" gender: "+person.gender+"");
		System.out.println("This person's discount is: "+calculateDiscount(person)+"%");
	}
	
	public static int calculateDiscount(Person person)
	{
		int discount = 0;
		
		if (person.age > 65)
		{
			discount = 100;
			return discount;
		}
		
		else if ((10 <= person.age) && (person.age <= 20))
		{
			discount = 50;
			return discount;
		}
		
		else if ((40 < person.age) && (person.gender == 'F'))
		{
			discount = 75;
			return discount;
		}
		else
		{
			if (person.age % 2 == 0)
			{
				discount = 25;
				return discount;
			}
			if (person.age % 2 == 1)
			{
				discount = 15;
				return discount;
			}
		}
		return discount;
	}

}
