package exercises;

import java.util.Scanner;

public class BookInputTest {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Book book = new Book();
		
		System.out.println("Please enter the title of the book");
		book.title = scan.nextLine();
		System.out.println("Please enter the author name");
		book.author = scan.nextLine();
		System.out.println("Please enter the the number of pages");
		book.numberOfPages = scan.nextInt();
		
		if (book.numberOfPages <= 0)
		{
			System.out.println("Please enter the the number of pages");
			book.numberOfPages = scan.nextInt();
		}
		
		System.out.println("The book title is: "+book.title+"");	
		System.out.println("The book author is: "+book.author+"");	
		System.out.println("The book has "+book.numberOfPages+" pages");	
	}

}
