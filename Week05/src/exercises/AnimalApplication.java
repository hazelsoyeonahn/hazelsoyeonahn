package exercises;

import java.util.Scanner;

public class AnimalApplication {

	public static void main(String[] args) {
		
		Animal[] animals = new Animal[4];
		Scanner scan = new Scanner(System.in);
		int[] instant = new int[4];
		int feed;
		
		for(int x = 0; x < 4; ++x) {
	
			System.out.println("Type 1 to create a Dog object or 2 to create a Cat object");
			instant[x] = scan.nextInt();
		
			if(instant[x] == 1) {
				animals[x] = new Dog();
			}
			
			else if(instant[x] == 2) {
				animals[x] = new Cat();
			}
			
			System.out.println("\n");
		}
		
		for(int y = 0; y < 4; ++y) {
			System.out.println("Select an animal to feed by entering a number within the range: 0 to 4");
			System.out.println("0 "+animals[0]);
			System.out.println("1 "+animals[1]);
			System.out.println("2 "+animals[2]);
			System.out.println("3 "+animals[3]);
			
			feed = scan.nextInt();
			
			if(feed == 0) {
				animals[0].feed();
			}
			else if(feed == 1) {
				animals[1].feed();
			}
			else if(feed == 2) {
				animals[2].feed();
			}
			else if(feed == 3) {
				animals[3].feed();
			}
			else if(feed == 4) {
				System.out.println("Input out of range, quitting.");
				break;
			}
			
			System.out.println("\n");
		}
		
		
		

	}

}
