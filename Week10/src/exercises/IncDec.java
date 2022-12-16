package exercises;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IncDec extends JFrame{
	int number = 50;
	private JLabel num, label;
	private JButton inc,dec;
	//constructor
	public IncDec(String name) {
		super(name);
		
		//choose to lay out components manually
		getContentPane().setLayout(null);
		
		//add initial number on the top
		num = new JLabel(""+number);
		num.setLocation(0, 0);
		num.setSize(350, 10);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setBackground(Color.cyan);
		num.setOpaque(true);
		getContentPane().add(num);
		
		//add title label
		label = new JLabel("Increment-Decrement");
		label.setLocation(5, 15);
		label.setSize(200, 10);
		getContentPane().add(label);
		
		//add increment button
		inc = new JButton("Increment");
		inc.setLocation(20, 40);
		inc.setSize(140, 50);
		inc.addActionListener(new ButtonListenerI());
		getContentPane().add(inc);
		
		//add decrement button
		dec = new JButton("Decrement");
		dec.setLocation(175, 40);
		dec.setSize(140, 50);
		dec.addActionListener(new ButtonListenerD());
		getContentPane().add(dec);
		
		//set program to stop when window is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,130);
		setResizable(false);
	}
	private class ButtonListenerI implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			number++;
			num.setText(""+number);
		}
	}
	
	private class ButtonListenerD implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			number--;
			num.setText(""+number);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new IncDec("Increment Decrement");
		frame.setVisible(true);
	}

}
