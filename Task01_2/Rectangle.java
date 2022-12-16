package Task01_2;

public class Rectangle extends Shape{
	protected static String shapeName = "Rectangle";
	private double width,length;
	public Shape rect;
	

	public Rectangle(double width, double length) {
		super(shapeName);
		this.width = width;
		this.length = length;
		
		//if width and length is same it is always square. 
		if(width == length) {
			super.setName("Square");
		}	
		
		//update calculated area
		calculateArea();
	}

	@Override
	public void calculateArea() {
		super.area = width*length;
		
	}
}
