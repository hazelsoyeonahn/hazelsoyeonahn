package Exercises;

public class ExceptionBasics2 {
	
	static boolean CAUSE_EXCEPTION = true;
	
	public static void main(String args[]) {
		
		for(int x = 1; x < 11; ++x) {
			try 
			{
				if(CAUSE_EXCEPTION)
					throw new Exception();	
			} 
			catch (Exception e) 
			{
			System.err.println(x+" Exception caught!");
			}
		}
	}
}
