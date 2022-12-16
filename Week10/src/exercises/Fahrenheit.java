package exercises;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Fahrenheit extends JPanel{
	private JLabel input, output, result;
	private JTextField fahrenheit;
	private JButton conversion;
	
	public Fahrenheit() {
		input = new JLabel("Enter Fahrenheit temperature:");
		output = new JLabel("Temperature in Celcius: ");
		result = new JLabel("---");
		fahrenheit = new JTextField(5);
		
		TempListener listener = new TempListener();
		fahrenheit.addActionListener(listener);
		conversion = new JButton("Conversion");
		conversion.addActionListener(listener);
		
		add(input);
		add(fahrenheit);
		add(output);
		add(result);
		add(conversion);
		setPreferredSize(new Dimension(300,105));
		setBackground(Color.yellow);
	}
	
	private class TempListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int fahTemp, celTemp;
			String text = fahrenheit.getText();
			fahTemp = Integer.parseInt(text);
			celTemp = (fahTemp - 32)*5/9;
			result.setText(Integer.toString(celTemp));
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fahrenheit");
		frame.add(new Fahrenheit());
		frame.pack();
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}

}


