package exercises;
import java.util.Scanner;

public class HowManySeconds {
	
	static final int SECONDS_IN_MINUTE = 60;
	static final int SECONDS_IN_HOUR = 3600;
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int UserInput;
		int hours;
		int minutes;
		int seconds;

		System.out.println("Enter the number of seconds:");
		UserInput = scan.nextInt();
		System.out.println("\n");
		
		hours = UserInput/SECONDS_IN_HOUR;
		int RemainedMinutes = UserInput%SECONDS_IN_HOUR;
		minutes = RemainedMinutes/SECONDS_IN_MINUTE;
		seconds = RemainedMinutes%SECONDS_IN_MINUTE;
		
		System.out.println(""+UserInput+" seconds is equivalent to");
		System.out.println(""+hours+" hours");
		System.out.println(""+minutes+" minutes");
		System.out.println(""+seconds+" seconds");	
	}
}
