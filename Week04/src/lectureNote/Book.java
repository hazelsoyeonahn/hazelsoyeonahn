package lectureNote;

public class Book {
	
	private String title;
	private double price;
	
	@Override
	public String toString()
	{
		return this.getTitle()+ " $"+this.getPrice();
	}
	
	public Book(String title,double price)
	{
		this.setTitle(title);
		this.setPrice(price);
	}
	
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	

}
