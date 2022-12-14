package exercises;
import java.util.Scanner;

public class Division {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int numerator;
		int denominator;
		double decimalEquivalence;

		System.out.println("Please enter the numerator");
		numerator = scan.nextInt();
		System.out.println("Please enter the denominator");
		denominator = scan.nextInt();
		
		

		decimalEquivalence = (float)numerator/denominator;
		
		System.out.println("The input fraction is: "+numerator+"/"+denominator+"");
		System.out.println("The decimal equivalence is: "+decimalEquivalence+"");
	}
}
