package Exercises;

public class MoneyTransferTester {

	public static void main(String[] args) {
		CustomerAccountUpdate to = new CustomerAccountUpdate("Bob");
		CustomerAccountUpdate from = new CustomerAccountUpdate("Alice");
		try {
			new MoneyTransfer(from, to, 100.00);
		}catch(MoneyTransferException me) {
			System.err.println(me);
		}
		try {
			new MoneyTransfer(from, to, -99.00);
		}catch(MoneyTransferException me) {
			System.err.println(me);
		}
	}
}
