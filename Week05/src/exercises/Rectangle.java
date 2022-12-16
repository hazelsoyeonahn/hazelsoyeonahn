package exercises;

public class Rectangle extends Shape{
	
	private int width = 2;
	private int height = 5;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public double computeArea() {
		return width*height;
	}

	@Override
	public String toString() {
		return "The area of the rectangle is: ";
	}
	

}
