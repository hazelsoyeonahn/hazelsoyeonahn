package examples;

abstract public class Position {
	public boolean taken;

	public Position(boolean taken)
	{
		this.taken = taken;
	}
	
	@Override
	public String toString()
	{
		return "["+(taken?"X":" ")+"]";
		
	}
	
}
