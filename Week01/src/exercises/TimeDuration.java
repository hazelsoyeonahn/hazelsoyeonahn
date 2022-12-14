package exercises;
import java.util.Scanner;

public class TimeDuration {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int hours;
		int minutes;
		int seconds;
		int TotalSecond;

		System.out.println("Enter the number of hours");
		hours = scan.nextInt();
		System.out.println("Enter the number of minutes");
		minutes = scan.nextInt();
		System.out.println("Enter the number of seconds");
		seconds = scan.nextInt();
		
		TotalSecond = (hours * 3600) + (minutes * 60) + seconds;
		
		System.out.println("\n");
		System.out.println("The total number of seconds is: "+TotalSecond+"");
	
	}
}
