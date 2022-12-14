package exercises;
import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String firstName;
		String lastName;
		String studentID;
		
		System.out.println("Please enter student's first name:");
		firstName = scan.nextLine();
		System.out.println("Please enter student's last name:");
		lastName = scan.nextLine();
		System.out.println("Please enter student's ID:");
		studentID = scan.nextLine();
		
		System.out.println("Calling 3 parameter constructor:");
		Student parameter3 = new Student(firstName, lastName, studentID);
		System.out.println("Student's first name: "+parameter3.firstname+" last name: "+parameter3.lastname+" ID: "+parameter3.studentID+"");
		
		System.out.println("Calling 2 parameter constructor:");
		Student parameter2 = new Student(firstName, lastName);
		System.out.println("Student's first name: "+parameter2.firstname+" last name: "+parameter2.lastname+" ID: "+parameter2.studentID+"");
		
		System.out.println("Calling zero parameter constructor:");
		Student parameter0 = new Student();
		System.out.println("Student's first name: "+parameter0.firstname+" last name: "+parameter0.lastname+" ID: "+parameter0.studentID+"");
		
	}

}
