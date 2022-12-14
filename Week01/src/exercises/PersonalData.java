package exercises;
import java.util.Scanner;

public class PersonalData {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String name;
		String birthday;
		String interests;
		String favoriteBook;
		String favoriteFilm;
		
		System.out.println("Name: ");
		name = scan.nextLine();
		System.out.println("Birthday: ");
		birthday = scan.nextLine();
		System.out.println("Interests: ");
		interests = scan.nextLine();
		System.out.println("Favorite book: ");
		favoriteBook = scan.nextLine();
		System.out.println("Favorite film: ");
		favoriteFilm = scan.nextLine();
		
		System.out.println("Name: "+name+"");
		System.out.println("Birthday: "+birthday+"");
		System.out.println("Interests: "+interests+"");
		System.out.println("Favorite book: "+favoriteBook+"");
		System.out.println("Favorote film: "+favoriteFilm+"");

	}
}
