package lectureNote;

public class TestingProgram {
	public static int sum(int x,Integer y) {
		return x+y;
	}
	public static void main(String[] args) {
		int[] scoreArray = new int[10];
		scoreArray[0] = 10;
		scoreArray[2] = 30;
		scoreArray[5] = 1;
		scoreArray[9] = 8;
		int maximum = scoreArray[0];
		
		//finding maximum value
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i]>maximum) {
				maximum = scoreArray[i];
			}
		}
		System.out.println(maximum);
	
		//how to use class array
		
		Book[] scoreArray = new Book[10];
		scoreArray[0] = new Book("Whatever", 7.99);
		scoreArray[1] = new Book("The life of Pi", 5.12);
		
		//changing string to integer using pre-defined wrapper class
		String numStr = "100";
		int num = Integer.parseInt(numStr);
		System.out.println(num);*/
		
		Integer num1 = new Integer(10); //integer object
		int num2 = 20; //integer primitive type
		System.out.println(sum(num1, num2)); 
		//primative type -> object called autoboxing (second parameter)
		//object -> primative type called unboxing (first parameter)
		
		//iterating all of the informations in the array wihtout any condition(no nullpointer expt)
		  	for(Book aBook:scoreArray) {
			System.out.println(aBook);
		}
		//System.out.println(scoreArray[0]);
	}

