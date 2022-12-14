package exercises;
import java.util.Scanner;

public class ThreeNumberAverage {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int number1;
		int number2;
		int number3;
		double average;

		System.out.println("Enter the first number");
		number1 = scan.nextInt();
		System.out.println("Enter the second number");
		number2 = scan.nextInt();
		System.out.println("Enter the third number");
		number3 = scan.nextInt();
		
		average = (double)(number1 + number2 + number3)/3;
		
		System.out.println("\n");
		System.out.println("The average of the numbers is: "+average+"");
	
	}
}
