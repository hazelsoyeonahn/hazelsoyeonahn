package examples;

public class Left extends Position{

	@Override
	public String toString()
	{
		return "L"+super.toString();
	}
	public Left(boolean taken) 
	{
		super(taken);
	}

}
