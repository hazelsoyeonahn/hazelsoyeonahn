package exercises;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MVCtemplate extends JFrame implements ActionListener {
	List list1,list2;
	JButton button1,button2,button3,button4,button5,button6,button7,button8;
	JTextField text1,text2;
	
	public MVCtemplate(){
		super("Shopping Cart");
		setSize(450,300);
		setLocation(100,100);
		setLayout(null);
		
		list1 = new List(15,true);
		list2 = new List(15,true);
		button1 = new JButton("->");
		button2 = new JButton("<-");
		
		add(list1);
		add(list2);
		add(button1);
		add(button2);
		
		list1.add("Book");
		list1.add("Music");
		list1.add("Clothes");
		list1.add("Coffee");
		
		list1.setBounds(10, 10, 150, 200);
		list2.setBounds(240,10,150,200);
		button2.setBounds(170, 100, 60, 40);
		button1.setBounds(170, 50, 60, 40);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		setVisible(true);
		
		ButtonEnable();
	}
	public void ButtonEnable() {
		if(list1.getItemCount()<=0) {
			button1.setEnabled(false);
		}
		if(list1.getItemCount()>0) {
			button1.setEnabled(true);
		}
		if(list2.getItemCount()<=0) {
			button2.setEnabled(false);
		}
		if(list2.getItemCount()>0) {
			button2.setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			int x;
			String s[] = list1.getSelectedItems();
			if(s.length != 0) {
				for(x = 0; x < s.length; ++x) {
					list2.add(s[x]);
					list1.remove(s[x]);
				}
			}
			ButtonEnable();
		}
	}
	
	public static void main(String args[]) {
		new MVCtemplate();
	}
}
