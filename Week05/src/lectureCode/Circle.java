package lectureCode;

public class Circle extends Shape {

	private double radius;
	public Circle(double radius)
	{
		this.radius = radius;
	}


	@Override
	public double computeArea() 
	{

		return Math.PI*Math.pow(radius, 2);

	}


}
