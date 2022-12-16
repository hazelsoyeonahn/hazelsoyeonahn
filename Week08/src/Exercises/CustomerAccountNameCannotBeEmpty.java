package Exercises;

public class CustomerAccountNameCannotBeEmpty extends IllegalArgumentException{
	public CustomerAccountNameCannotBeEmpty(String message) {
		super(message);
	}
	public CustomerAccountNameCannotBeEmpty() {
		super();
	}
}
