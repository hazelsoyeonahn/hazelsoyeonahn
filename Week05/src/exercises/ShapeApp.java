package exercises;
import java.util.Scanner;

public class ShapeApp {

	public static void main(String[] args) {
		
		Shape[] shape = new Shape[10];
		Scanner scan = new Scanner(System.in);
		int userInput;
		
		for(int x = 0; x < 10; ++x) {
			System.out.println("1 Create a Circle Object");
			System.out.println("2 Create a Rectangle object");
			System.out.println("3 Stop");
			
			userInput = scan.nextInt();
			
			if(userInput == 1) {
				shape[x] = new Circle(5);
			}
			
			else if(userInput == 2) {
				shape[x] = new Rectangle(5, 8);
			}
			
			else if(userInput == 3) {
				break;
			}
			
			System.out.println(""+shape[x]+shape[x].computeArea()+"\n");
		}

	}

}
