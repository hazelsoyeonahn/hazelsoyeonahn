package Exercises;

public class CustomerAccountNameCannotBeNull extends IllegalArgumentException {	
	public CustomerAccountNameCannotBeNull(String message) {
		super(message);
	}
	public CustomerAccountNameCannotBeNull() {
		super();
	}
}
