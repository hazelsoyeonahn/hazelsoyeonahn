package exercises;

public class Grade {
	private int percentage; //a value in the range 0...100
	public Grade(int percentage) {
		
		this.percentage = percentage;
	}
	
	public void setPercentage(int percentage) {
		
		if((percentage >= 0)&&(percentage<=100))
			this.percentage = percentage;
		else
			this.percentage = 0;
	}
	
	public int getPercentage() {
		return this.percentage;
	}
	
	public String toString()
	{
		return "The grade is " +this.percentage;
	}
}
