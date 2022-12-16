package Exercises;

public class CustomerAccountTester {
	public static void main(String[] args) {
		try {
			CustomerAccount NameIsNull = new CustomerAccount(null);
		}
		catch(CustomerAccountNameCannotBeNull e){
			System.out.println(e.getMessage());
		}
		try {
			CustomerAccount NameIsEmpty = new CustomerAccount("");
		}
		catch(CustomerAccountNameCannotBeEmpty e) {
			System.out.println(e.getMessage());
		}
	}
}
