package Exercises;

public class CustomerAccount {
	private String customerName;
	
	public CustomerAccount(String customerName) {
		this.customerName = customerName;
		if(customerName == null) {
			throw new CustomerAccountNameCannotBeNull("Customer account cannot be null.");
		}
		if(customerName.length() == 0) {
			throw new CustomerAccountNameCannotBeEmpty("Customer account cannot be empty.");
		}
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
		if(customerName == null) {
			throw new CustomerAccountNameCannotBeNull("Customer account cannot be null.");
		}
		if(customerName.length() == 0) {
			throw new CustomerAccountNameCannotBeEmpty("Customer account cannot be empty.");
		}
	}

	@Override
	public String toString() {
		return customerName;
	}
}
