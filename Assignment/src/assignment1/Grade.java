package assignment1;

/*
 * A simple enum class that maintains grades enums and instant variables.
 * The instant variables includes two integer values of low and high grades.
 * A boolean value for figuring out if student have passed the paper or not.
 * A string value is to store the string of Grade.
 * 
 * The class contains a constructor, a toString method, get and set methods 
 * 
 * @author Hazel Ahn 16945085
 */

public enum Grade {
	
	
	//enums of grades
	//@param(int low, int high, boolean pass)
	APLUS(90,100,true), A(85,89,true), AMINUS(80,84,true), BPLUS(75,79,true), B(70,74,true), BMINUS(65, 69, true), CPLUS(60,64,true), C(55,59,true), CMINUS(50,54,true), D(0,49,false);
	
	private int low; //lowest range
	private int high; //highest range
	private boolean pass; //check if passed
	private String returnGrade; //return this string
	
	// constructor with low, high, boolean parameters
	// within range of grade, return to print out to console
	private Grade(int low, int high, boolean pass) {
		this.low = low;
		this.high = high;
		this.pass = pass;
		
		if (low == 90) {
			returnGrade = "A+";
		}
		else if(low == 85) {
			returnGrade = "A";
		}
		else if(low == 80) {
			returnGrade = "A-";
		}
		else if(low == 75) {
			returnGrade = "B+";
		}
		else if(low == 70) {
			returnGrade = "B";
		}
		else if(low == 65) {
			returnGrade = "B-";
		}
		else if(low == 60) {
			returnGrade = "C+";
		}
		else if(low == 55) {
			returnGrade = "C";
		}
		else if(low == 50) {
			returnGrade = "C-";
		}
		else if(low == 0) {
			returnGrade = "D";
		}
	}
	
	// printing out to console
	public String toString() {
		return returnGrade;
	}
	
	// method to get boolean
	public boolean ispass() {
		return pass;
	}
	
	// method to get lowest range
	public int getLow() {
		return low;
	}
	
	// method to get highest range
	public int getHigh() {
		return high;
	}
}
