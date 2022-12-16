package ex3_6;

/**
 * Class which demonstrates how bin sort can be used to
 * sort distinct integer numbers between 0 and MAX_VALUE
 *
 */
public class BinSort {
	public static void main(String[] args) {
		//distinct integer values between 0 to MAX_VALUE
		int[] list = {17, 2, 2,23, 7, 41, 29, 19, 43, 31, 5, 11, 47, 13, 3, 37};
		final int MAX_VALUE = 100;
		boolean[] flags = new boolean[MAX_VALUE+1]; //initially all false
		int[] temp = new int[MAX_VALUE+1];
		
		int x,y;
		int z = 0;
		
		//find duplicate number in the array and save it into temp array
		for(x=0; x<list.length; x++) {
			for(y=x+1; y<list.length; y++) {
				if(list[x] == list[y]) {
					temp[z] = list[x];
					++z;
				}
			}
		}
		
		//determine which bin should be set to true
		for(int i=0; i<list.length; i++) {
			flags[list[i]] = true;
		}
			
		
		//use the flags to put the numbers back in the list sorted
		int flagNo = 0;
		
		for(int i=0; i<list.length; i++) {
			//find the next flag that is true
			while(flagNo<flags.length && !flags[flagNo])
				flagNo++;
			//add flag
			list[i] = flagNo;
			//if there is duplicate then add it to the next position in array
			if(temp[i] != 0 && temp[i] == flagNo) {
				list[i+1] = flagNo;
				//make sure i moved to the next position
				i++;
			}
			//make sure flagNo is moved to the next position
			flagNo++;
		}
		
		//output the results
		for(int i=0; i<list.length; i++)
			System.out.print(((i>0)?", ":"") + list[i]);
		System.out.println();
	}
}
