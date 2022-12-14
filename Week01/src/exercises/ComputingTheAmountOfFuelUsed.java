package exercises;
import java.util.Scanner;

public class ComputingTheAmountOfFuelUsed {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int miles;
		double gallons;
		double milesPerGallon;

		System.out.println("Enter the number of miles:");
		miles = scan.nextInt();
		System.out.println("Enter the gallons of fuel used:");
		gallons = scan.nextDouble();

		milesPerGallon = miles / gallons;
		
		System.out.println("\n");
		System.out.println("Miles Per Gallon: "+milesPerGallon+"");
	}
}