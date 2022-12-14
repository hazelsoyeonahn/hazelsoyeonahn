package exercises;
import java.util.Scanner;

public class ConvertMilesToKilometers {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int number1;
		double kilometers;

		System.out.println("Enter the number of miles:");
		number1 = scan.nextInt();

		
		kilometers = (float)(number1) * 1.60935;
		
		if (number1 < 0)
		{
			System.out.println("Please enter a value greater than 0!");
		}
		else
		{
			System.out.println("The numbers of kms is: "+kilometers+"");
		}
	}
}
