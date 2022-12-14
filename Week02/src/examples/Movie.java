package examples;
/**
 * Movie objects contain a title and rating of a movie.
 * Movie objects are constructed with a given title and rating,
 * the title only or no information.
 * 
 * */
public class Movie 
{
	String title;
	int rating;


	public Movie(String title)
	{
		this.title = title;
		this.rating = -1;
	}

	public Movie()
	{
		this.title  = "?";
		this.rating = -1;
	}

	public Movie(String title,int rating)
	{
		this.title = title;
		this.rating = rating;
	}
}
