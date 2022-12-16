package Task01_2;

public class Circle extends Shape {
	
	private static String shapeName = "Circle";
	private double radius;

	public Circle(double radius) {
		super(shapeName);
		this.radius = radius;
		calculateArea();
	}

	@Override
	public void calculateArea() {
		super.area = Math.PI*radius*radius;
	}

}
