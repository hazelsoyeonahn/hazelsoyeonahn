package exercises;

public class FundInsufficientException extends Exception{
	private int balance;
	private int withdraw;
	
	FundInsufficientException(int bal, int with){
		this.balance = bal-with;
		this.withdraw = with;
	}
	
	public String toString() {
		return "You have not enough money in your bank account"+"\nwithdraw: "+withdraw+" balance: "+balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

}
