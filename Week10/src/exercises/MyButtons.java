package exercises;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class MyButtons {
	public static void main(String[] args) {
		JFrame f = new JFrame("My Window");
		JButton b = new JButton("Random Phrase");
		JLabel l = new JLabel("Hello World!");
		String phrase[] = {"Hello World!", "How are you?", "Welcome!", "Great","Goodbye!"};
		Random r = new Random();
		
		b.setBounds(130, 100, 150, 100);
		l.setBounds(170,50,100,30);
		f.add(l);
		f.add(b);
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int i = r.nextInt(5);
				l.setText(phrase[i]);
			}
		});
	}
}

