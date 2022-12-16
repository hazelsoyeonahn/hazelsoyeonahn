package Exercises;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ComputeProduct {
	private static Scanner scanner;
	public static void product() throws InputMismatchException{
		try {
		System.out.println("Welcome to the calculator.");
		System.out.println("Enter first number:");
		int value1 = scanner.nextInt();
		System.out.println("Enter second number:");
		int value2 = scanner.nextInt();
		System.out.println("Product is: "+(value1*value2));
		}
		catch(InputMismatchException inputMismatchException)
		{
			System.out.println("You must input integer values");
			System.err.println("Exceptional event: "+inputMismatchException);
			scanner.next();
		}
	}
	public static void main(String args[]) {
		scanner = new Scanner(System.in);
		product();
	}

}
