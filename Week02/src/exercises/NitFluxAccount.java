package exercises;

public class NitFluxAccount {
	String emailAddress;
	int months;
	double moneyEachMonth = 4.99;
	AnxBankAccount bankdetails;
	
	public NitFluxAccount(String emailAddress, int months) {
		this.emailAddress = emailAddress;
		this.months = months;
	}
	
	public NitFluxAccount(String emailAddress, int months, AnxBankAccount bankdetails) {
		this.emailAddress = emailAddress;
		this.months = months;
		this.bankdetails = new AnxBankAccount();
	}
	
	public double computeCostumerPay()
	{
		return (this.months * this.moneyEachMonth);
	}
}
