package lectureCode;

public class ShapeApp {


	public static void main(String[] args) 
	{
		Shape[] shapes = new Shape[4];
		shapes[0] = new Rectangle(10,10);
		shapes[1] = new Rectangle(20,30);
		shapes[2] = new Circle(5.6);
		shapes[3] = new Circle(5.56);
	
		for(Shape aShape : shapes)
		{
			System.out.println(aShape.computeArea());
			aShape.setX(100);
			aShape.setY(-3);
			
		}
		
		//for(int i=0;i<shapes.length;i++)
	//	{
	//		System.out.println(shapes[i].computeArea());
	//	}

		//Shape s = new Shape();



	}

}
