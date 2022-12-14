package examples;

/**
 * The MovieApp uses the MovieLibrary and Movie classes to instantiate and
 * populate a library of three movies.
 * 
 * What would happen if you changed the numbnerOfMovies instance variable to 5?
 * e.g. library.numberOfMovies = 5;
 * 
 */
public class MovieApp {

	public static void main(String[] args) {
		Movie movie00 = new Movie("The Third Man", 5);

		Movie movie01 = new Movie("Batman");
		movie01.rating = 3;

		Movie movie02 = new Movie();
		movie02.title = "Casablanca";
		movie02.rating = 5;

		System.out.println("Movie library contents");
		// prints movie 00
		System.out.println("Movie title: " + movie00.title);
		System.out.println("Movie rating: " + movie00.rating);
		// prints movie 01
		System.out.println("Movie title: " + movie01.title);
		System.out.println("Movie rating: " + movie01.rating);
		// prints movie 02
		System.out.println("Movie title: " + movie02.title);
		System.out.println("Movie rating: " + movie02.rating);
	}

}
