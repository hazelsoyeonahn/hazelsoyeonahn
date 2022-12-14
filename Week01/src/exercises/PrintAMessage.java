package exercises;
import java.util.Scanner;

public class PrintAMessage {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String message;
		
		System.out.println("What is the message?");
		
		message = scan.nextLine();
		System.out.println("The message is \""+message+"\".");
	}
}
