package exercises;
import java.util.Scanner;

public class CoinChangerApplication {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in );
		
		int tenCents = 0;
		int twentyCents = 0;
		int fiftyCents = 0;
		int oneDollar = 0;
		int twoDollar = 0;
		char playAgain = 0;
		
		do {
			
			System.out.println("Welcome to the Coin Changer Machine. Please input your coins:");
			System.out.println("Number of 10c coins:");
			tenCents = scanner.nextInt();
			System.out.println("Number of 20c coins:");
			twentyCents = scanner.nextInt();
			System.out.println("Number of 50c coins:");
			fiftyCents = scanner.nextInt();
			System.out.println("Number of dollar coins:");
			oneDollar = scanner.nextInt();
			System.out.println("Number of two dollar coins:");
			twoDollar = scanner.nextInt();
			CoinChanger aCoinChanger = new CoinChanger(tenCents,twentyCents,fiftyCents,oneDollar,twoDollar);
			System.out.println(aCoinChanger);
			
			
			System.out.println("Would you like to continue? (Y?)");
			playAgain = scanner.next().charAt(0);
		} while (playAgain == 'Y');
	}
}
