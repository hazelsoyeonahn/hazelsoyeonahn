package Task01_2;

public class ShapeCalculator1 {
	public static void main(String[] args) {
		//declare circle object to print info
		Circle cirObj = new Circle(2.5);
		cirObj.printInfo();
		
		//declare rectangle object to print info
		Rectangle recObj = new Rectangle(12,16.5);
		recObj.printInfo();
		
		//declare square object to print info
		Square squObj = new Square(3.3);
		squObj.printInfo();

	}
}
