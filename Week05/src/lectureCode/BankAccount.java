package lectureCode;

/**
 * 
 * @author Jamal and Kenneth Johnson
 *
 */
public class BankAccount {
	private String customer;
	private int accountID;
	private double balance;
	public BankAccount(String customer){
		this.customer=customer;
		this.accountID=0;
		this.balance=0;	
	}
	
	protected void setBalance(double balance){
		this.balance=balance;
	}
	
	public double getBalance(){
		return balance;
	}
	public void withdraw(double amount){
		if(balance>=amount)
			balance-=amount;
	}
	public void deposit(double amount){
		balance+=amount;
	}
	public String getCustomer() {
		return customer;
	}
	public int getAccountID() {
		return accountID;
	}
	public String toString(){
		return "Name: "+this.customer+" balance: $"+this.balance;
	}
}
