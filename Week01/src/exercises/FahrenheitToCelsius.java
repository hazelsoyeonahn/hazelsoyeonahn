package exercises;
import java.util.Scanner;

public class FahrenheitToCelsius {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int fahrenheit;
		double celcius;
		
		System.out.println("Please enter the temperature in Fahrenheit:");
		fahrenheit = scan.nextInt();
		
		celcius = ((fahrenheit - 32)*5)/9;
		
		System.out.println("The temperature "+fahrenheit+"F is "+celcius+"C");
	}
}
