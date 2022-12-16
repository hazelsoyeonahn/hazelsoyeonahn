package examples;

public class BookPosApp {

	public static void main(String[] args) {

		Position[][] positions = new Position[][] {
			new Position[] {new Left(true), new Center(false), new Right(true)},
			new Position[] {new Left(true), new Right(false)},
			new Position[] {new Left(false), new Center(false),new Center(false),new Center(false),new Center(false),new Center(false),new Right(false)},
		//	new Position[] {new Up(false)}
		};


		for(Position[] row : positions)
		{
			for(Position c : row)
			{
				System.out.print(c+" ");

			}
			System.out.println();

		}



	}

}
