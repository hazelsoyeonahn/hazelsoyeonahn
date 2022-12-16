package lectureCode;

/**
 * 
 * @author Jamal and Kenneth Johnson 
 * 
 */

public class OverDraft extends BankAccount{
	private double debt;
	public String toString(){
		return "Name: "+this.getCustomer()+" balance: "+this.getBalance()+" Overdraft: "+debt;
	}

	public OverDraft(String customer) {
		super(customer);
		this.debt=0.0;
	}


	public void borrow(double debt){
		this.debt-=debt;

	}
	//if the amount to withdraw is greater than the
	//account balance, then withdraw the balance
	//and borrow the remaining amount


	public void withdraw(double amount){
		if(amount > this.getBalance()){
			double borrow = amount - this.getBalance();
			super.withdraw(this.getBalance());
			this.borrow(borrow);

		} else super.withdraw(amount);		
	}
}
