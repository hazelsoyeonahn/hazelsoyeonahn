package exercises;

public class Circle extends Shape{
	
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	
	public double computeArea() {
		return radius*radius*3.14;
	}
	
	@Override
	public String toString() {
		return "The area of the circle is: ";
	}

}
