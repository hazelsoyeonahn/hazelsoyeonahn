package Exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeProductMenu {
	private static Scanner scanner;
	private static int quitOrno;
	public static void product() throws InputMismatchException{
		try {
		System.out.println("Enter first number:");
		int value1 = scanner.nextInt();
		System.out.println("Enter second number:");
		int value2 = scanner.nextInt();
		System.out.println("Product is: "+(value1*value2));
		}
		catch(InputMismatchException inputMismatchException)
		{
			System.err.println("Error reading integer value");
			scanner.next();
		}
	}
	public static void main(String args[]) {
		System.out.println("Welcome to the calculator.");
		scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. Compute product");
			System.out.println("2. quit");
			try {
				quitOrno = scanner.nextInt();
				if(quitOrno == 1) {
					product();
				}
				else if(quitOrno == 2) {
					System.out.println("Goodbye!");
					break;
				}
				else {
					System.out.println("Invalid menu input. Please try again.");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("Invalid menu input.Please try again.");
				scanner.next();
			}
		}
	}

}
