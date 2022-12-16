package examples;

public class UniApp {

	public static void main(String[] args) {

		Person aPerson = new Person("Jamal", 100, new Address());

		System.out.println(aPerson);
		Staff staff = new Staff();
		staff.payday();

	}

}
