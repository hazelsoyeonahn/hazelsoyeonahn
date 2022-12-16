package lectureCode;

/**
 * 
 * @author Jamal and Kenneth Johnson
 *
 */

public class BankAccountTest {

	public static void main(String args[]){
		BankAccount b1 = new BankAccount("Penny Pinshur");
		System.out.println(b1);
		System.out.println("BankAccount Depositing: $100.50");
		b1.deposit(100.50);
		System.out.println(b1);		
		System.out.println("BankAccount Withdraw: $75.00");
		b1.withdraw(75.00);
		System.out.println(b1);

		System.out.println();
		SmartSaver ssa1 = new SmartSaver("Mr. Banks");
		System.out.println(ssa1);
		System.out.println("SuperSaverAccount Deposit: $100.00");
		ssa1.deposit(100);
		System.out.println("SuperSaverAccount Withdraw: $75.00");
		ssa1.withdraw(75.00);
		System.out.println(ssa1);
		
		
		System.out.println();
		OverDraft draft = new OverDraft("Mr. Burrows");
		System.out.println(draft);
		System.out.println("OverDraft Deposit: $200.00");
		draft.deposit(200);
		System.out.println("OverDraft Withdraw: $350.00");
		draft.withdraw(350.00);
		System.out.println(draft);
		

	}
}
