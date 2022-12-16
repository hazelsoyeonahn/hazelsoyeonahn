package exercises;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerPayRoll cpr = new CustomerPayRoll();
		
		//printing out sorted arrayList
		for(Customer c: CustomerPayRoll.inputCustomer()) {
			System.out.println(c.getName());
		}
	}

}
