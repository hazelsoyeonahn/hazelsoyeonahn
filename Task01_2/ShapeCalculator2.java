package Task01_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeCalculator2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		
		System.out.println("Please select:");
		System.out.println("(1) Rectangle");
		System.out.println("(2) Circle");
		System.out.println("(3) Square");
		System.out.println();
		
		try {
			userInput = scan.nextInt();
			
			if(userInput == 1) {
				System.out.println("Please input width:");
				double width = scan.nextDouble();
				
				System.out.println("Please input length:");
				double length = scan.nextDouble();
				
				//declare rectangle object and print info
				Rectangle recObj = new Rectangle(width,length);
				recObj.printInfo();
			}
			else if(userInput == 2) {
				System.out.println("Please input radius:");
				double radius = scan.nextDouble();
				
				//declare circle object to print info
				Circle cirObj = new Circle(radius);
				cirObj.printInfo();
			}		
			else if(userInput == 3) {
				System.out.println("Please input side length:");
				double side = scan.nextDouble();
				
				//declare square object to print info
				Square squObj = new Square(side);
				squObj.printInfo();
			}
			else {
				System.out.println("Wrong input");
			}
		}catch(InputMismatchException e) {
			System.out.println("Invalid input. Not an integer");
		}
		
		scan.close();
	}
}
