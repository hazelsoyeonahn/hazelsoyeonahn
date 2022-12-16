package exercises;

public class BankAccounts {
	private int accNum;
	private int amount;
	
	public BankAccounts(int accNum, int amount) {
		this.accNum = accNum;
		this.amount = amount;
	}

	public void deposit(int amt) {
		amount = amount + amt;
	}
	
	public void withdraw(int amt) throws FundInsufficientException{
		if(amt>amount) {
			throw new FundInsufficientException(amount, amt);
		}
		else {
			amount = amount - amt;
		}
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
