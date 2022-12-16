package ex1_2;
/*
 * This class has a selection sort algorithm.
 * This class will explain why selection sort is O(n^2)s
 */

public class SelectionSortOrder {
	
	public void sort(int array[]) {
		
		int length = array.length;
		
		for(int i=0; i<length-1; i++) {
			//minimum number
			int min = i;
			for(int j=i+1; j<length; j++) {
				if(array[j]<array[min])
					min = j;
			}
			
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}
	
	void printArray(int array[]) {
		
		int length = array.length;
		for(int i=0; i<length; ++i)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		SelectionSortOrder st = new SelectionSortOrder();
		
		int array[] = {32, 27, 48, 99, 67, 71};
		
		System.out.println("Before sorting...");
		st.printArray(array);
		st.sort(array);
		
		System.out.println("\nAfter sorting...");
		st.printArray(array);
		
		System.out.println("\nSelection Sort contains 2 for loops.\n"
				+ "We know that if there is 2 for loops \n"
				+ "The order of the algorithm is O(n^2) \n"
				+ "as there are two n multipying each other");

		
	}
	
}
