package lectureCode;
import java.util.Scanner;

public class SquareShape{
	/**
	*
	* This class demonstrates an application which prompts
	* for and reads an integer representing the length of a
	* square's side and then prints the square's perimeter and area.
	*
	* */
	public static void main(String[] args){
		System.out .println("Please enter the length's of the square's side: ");
		Scanner scan = new Scanner(System.in );
		int length = scan.nextInt();
		System.out .println("The length of the square's side is: ");
		System.out .println(length);
		System.out .println("The perimeter of the square is: ");
		System.out .println(length*4);
		System.out .println("The area of the square is: ");
		System.out .println(length*length);
	}
}