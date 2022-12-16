package exercises;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bank extends JFrame implements ActionListener{
	JLabel lab1 = new JLabel(" ");
	JLabel lab2 = new JLabel(" ");
	TextField t[] = new TextField [4];
	JLabel l[]= new JLabel[4];
	JButton but1 = new JButton("Create Account");
	JButton but2 = new JButton("Test Account");
	BankAccounts b;
	
	public Bank(){
		addWindowListener(new NewWindowAdapter());
		setLayout(new GridLayout(2,0));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		but1.addActionListener(this);
		but2.addActionListener(this);
		p1.setLayout(new GridLayout(5,2));
		p2.add(lab2);
		p2.add(lab1);
		l[0] = new JLabel("Account Number");
		l[1] = new JLabel("Initial Balance");
		l[2] = new JLabel("Deposit Amount");
		l[3] = new JLabel("Withdraw Amount");
		for(int x = 0; x <4; ++x) {
			t[x] = new TextField(10);
			p1.add(l[x]);
			p1.add(t[x]);
		}
		p1.add(but1);
		p1.add(but2);
		but2.setVisible(false);
		l[2].setVisible(false);
		l[3].setVisible(false);	
		t[2].setVisible(false);
		t[3].setVisible(false);
		add(p1);
		add(p2);
	}
	int updatedDeposit;
	int updatedWithdraw;
	String testAccount(int deposit, int withdraw) {
		String message;
		updatedDeposit += deposit;
		updatedWithdraw += withdraw;
		b.deposit(updatedDeposit);
		message = "Transaction successful";
		try {
			b.withdraw(updatedWithdraw);
		}catch(FundInsufficientException f) {
			f = new FundInsufficientException(b.getAmount(), withdraw);
			message = String.valueOf(f);
		}
		return message;	
	}
	public void actionPerformed(ActionEvent a) {
		String string = a.getActionCommand();
		if(string.equals("Create Account"));
		{
			b = new BankAccounts(Integer.parseInt(t[0].getText()),Integer.parseInt(t[1].getText()));
			but2.setVisible(true);
			l[2].setVisible(true);
			l[3].setVisible(true);
			t[2].setVisible(true);
			t[3].setVisible(true);
			but1.setVisible(false);
			l[0].setVisible(false);
			l[1].setVisible(false);
			t[0].setVisible(false);
			t[1].setVisible(false);
			lab1.setText("Account: "+b.getAccNum()+"       Current Balance: "+b.getAmount());
		}
		if(string.equals("Test Account")) {
			lab1.setText(testAccount(Integer.parseInt(t[2].getText()),Integer.parseInt(t[3].getText())));
			lab2.setText("Account: "+b.getAccNum()+"       Current Balance: "+b.getAmount());
		}
	}
	public static void main(String arg[]) {
		Bank test = new Bank();
		test.setTitle("Bank Account");
		test.setSize(500, 200);
		test.setVisible(true);
		test.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
