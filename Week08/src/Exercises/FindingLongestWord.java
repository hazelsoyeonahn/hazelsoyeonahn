package Exercises;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindingLongestWord {
	public static String findLongestWord(String FileName) {
		int max = 0;
		String current = "";
		String longest = "";
		
		try {
		Scanner scan = new Scanner(new File(FileName));
			while(scan.hasNext()) {
				current = scan.next();
				if(current.length()>max) {
					longest = current;
					max = longest.length();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return longest;
	}
	
	public static void main(String[] args) {
		System.out.println("Longest word in append.txt file is "+findLongestWord("append.txt"));
	}
}
