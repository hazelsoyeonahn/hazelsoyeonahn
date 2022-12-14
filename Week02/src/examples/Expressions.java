package examples;

public class Expressions {
	/**
	*
	* This class demonstrates output of a variety of
	* numerical typed expressions in Java.
	*
	* Results are appended to a character string and output to the console.
	*
	* */
	public static void main(String[] args){
		//output of the modulus operator
		System.out .println("Example output from the modulus operation");
		System.out .println(" 17 % 4 = "+(17 % 4));
		System.out .println("-20 % 3 = "+(-20 % 3));
		System.out .println("-10 % 5 = "+(-10 % 5));
		System.out .println("3.3 % 8 = "+(3.3 % 8));
		//if any operand of any arithmetic operation
		//is a floating point type then floating point
		//operator is used:
		System.out .println("\nExample output from floating point operations");
		System.out .println("17.6/4 = "+(17.6/4));
		System.out .println("-1.0+3.3 = "+(-1.0+3.3));
		System.out .println("90.42-81.3 = "+(90.42-81.3));
		//the division operation might lead to unexpected results
		System.out .println("\nExample output from division operations");
		System.out .println("10/4 = "+ (10/4));
		System.out .println("10.0/4 = "+(10.0/4));
		System.out .println("10/4.0 = "+(10/4.0));
		System.out .println("10.0/4.0 = "+(10.0/4.0));
	}
}
