package tree;
/*
 * GUI class of BalancedPersistentSet.
 * This class represent of Black-Red tree.
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BalancedGUI extends JPanel{
	private BinarySearchTree bTree;
	private BalancedPersistentSet rbTree;
	static String element;
	static JPanel panel = new JPanel();
	static JTextField elementInput = new JTextField(10);
	char[] copyBtree;
	Color color;
	
	public BalancedGUI() {
		rbTree = new BalancedPersistentSet();
		setPreferredSize(new Dimension(1100,600));
		setBackground(Color.white);
	}
	
	public <E> void addElement(String s) {
		rbTree.insert(s);	
		elementInput.setText("");
		this.repaint();
	}
	
	public <E> void removeElement(String s) {
		bTree.remove(s);
		elementInput.setText("");
		this.repaint();
	}
	
	int xleft = 100;
	int down = 70;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		//add all possible nodes
		if(rbTree.rootNode != null) {
			//rootnode
			g.drawString(rbTree.rootNode.element.toString(),500, 20);
			
			//leftside
			if(rbTree.rootNode.leftChild != null) {
				g.drawLine(500, 30, 300, down);
				if(rbTree.rootNode.leftChild.color != null && rbTree.rootNode.leftChild.color.equals(Color.black))
					g.setColor(Color.black);
				else if(rbTree.rootNode.leftChild.color != null && rbTree.rootNode.leftChild.color.equals(Color.red))
					g.setColor(Color.red);
				g.drawString(rbTree.rootNode.leftChild.element.toString(),300, 20+down);
				g.setColor(Color.black);
				
				if(rbTree.rootNode.leftChild.leftChild != null) {
					g.drawLine(300, 30+down, 200, down*2);
					if(rbTree.rootNode.leftChild.leftChild.color != null && rbTree.rootNode.leftChild.leftChild.color.equals(Color.black))
						g.setColor(Color.black);
					else if(rbTree.rootNode.leftChild.leftChild.color != null && rbTree.rootNode.leftChild.leftChild.color.equals(Color.red))
						g.setColor(Color.red);
					g.drawString(rbTree.rootNode.leftChild.leftChild.element.toString(),200, 20+(down*2));
					g.setColor(Color.black);
					
					if(rbTree.rootNode.leftChild.leftChild.leftChild != null) {
						g.drawLine(200, 30+(down*2), 100, down*3);
						if(rbTree.rootNode.leftChild.leftChild.leftChild.color != null && rbTree.rootNode.leftChild.leftChild.leftChild .color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.leftChild.leftChild.leftChild.color != null && rbTree.rootNode.leftChild.leftChild.leftChild .color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.leftChild.leftChild.leftChild.element.toString(),100, 20+(down*3));
						g.setColor(Color.black);
					}
					
					if(rbTree.rootNode.leftChild.leftChild.rightChild != null) {
						g.drawLine(200, 30+(down*2), 250, down*3);
						if(rbTree.rootNode.leftChild.leftChild.rightChild.color != null && rbTree.rootNode.leftChild.leftChild.rightChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.leftChild.leftChild.rightChild.color != null && rbTree.rootNode.leftChild.leftChild.rightChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.leftChild.leftChild.rightChild.element.toString(),250, 20+(down*3));
						g.setColor(Color.black);
					}
				}
				
				if(rbTree.rootNode.leftChild.rightChild != null) {
					g.drawLine(300, 30+down, 400, down*2);
					if(rbTree.rootNode.leftChild.rightChild.color != null && rbTree.rootNode.leftChild.rightChild.color.equals(Color.black))
						g.setColor(Color.black);
					else if(rbTree.rootNode.leftChild.rightChild.color != null && rbTree.rootNode.leftChild.rightChild.color.equals(Color.red))
						g.setColor(Color.red);
					g.drawString(rbTree.rootNode.leftChild.rightChild.element.toString(),400, 20+(down*2));
					g.setColor(Color.black);
					
					if(rbTree.rootNode.leftChild.rightChild.leftChild != null) {
						g.drawLine(400, 30+(down*2), 310, down*3);
						if(rbTree.rootNode.leftChild.rightChild.leftChild.color != null && rbTree.rootNode.leftChild.rightChild.leftChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.leftChild.rightChild.leftChild != null && rbTree.rootNode.leftChild.rightChild.leftChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.leftChild.rightChild.leftChild.element.toString(),310, 20+(down*3));
						g.setColor(Color.black);
					}
					
					if(rbTree.rootNode.leftChild.rightChild.rightChild != null) {
						g.drawLine(400, 30+(down*2), 490, down*3);
						if(rbTree.rootNode.leftChild.rightChild.rightChild.color != null && rbTree.rootNode.leftChild.rightChild.rightChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.leftChild.rightChild.rightChild.color != null && rbTree.rootNode.leftChild.rightChild.rightChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.leftChild.rightChild.rightChild.element.toString(),490, 20+(down*3));
						g.setColor(Color.black);
					}
				}
			}
			//rightside
			if(rbTree.rootNode.rightChild != null) {
				g.drawLine(500, 30, 700, down);
				if(rbTree.rootNode.rightChild.color != null && rbTree.rootNode.rightChild.color.equals(Color.black))
					g.setColor(Color.black);
				else if(rbTree.rootNode.rightChild.color != null && rbTree.rootNode.rightChild.color.equals(Color.red))
					g.setColor(Color.red);
				g.drawString(rbTree.rootNode.rightChild.element.toString(),700,  20+down);
				g.setColor(Color.black);
				
				if(rbTree.rootNode.rightChild.leftChild != null) {
					g.drawLine(700, 30+down, 600, down*2);
					if(rbTree.rootNode.rightChild.leftChild.color != null && rbTree.rootNode.rightChild.leftChild.color.equals(Color.black))
						g.setColor(Color.black);
					else if(rbTree.rootNode.rightChild.leftChild.color != null && rbTree.rootNode.rightChild.leftChild.color.equals(Color.red))
						g.setColor(Color.red);
					g.drawString(rbTree.rootNode.rightChild.leftChild.element.toString(),600, 20+(down*2));
					g.setColor(Color.black);
					
					if(rbTree.rootNode.rightChild.leftChild.leftChild != null) {
						g.drawLine(600, 30+(down*2), 530, down*3);
						if(rbTree.rootNode.rightChild.leftChild.leftChild.color != null && rbTree.rootNode.rightChild.leftChild.leftChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.rightChild.leftChild.leftChild.color != null && rbTree.rootNode.rightChild.leftChild.leftChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.rightChild.leftChild.leftChild.element.toString(),530, 20+(down*3));
						g.setColor(Color.black);
					}
					
					if(rbTree.rootNode.rightChild.leftChild.rightChild != null) {
						g.drawLine(600, 30+(down*2), 670, down*3);
						if(rbTree.rootNode.rightChild.leftChild.rightChild.color != null && rbTree.rootNode.rightChild.leftChild.rightChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.rightChild.leftChild.rightChild.color != null && rbTree.rootNode.rightChild.leftChild.rightChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.rightChild.leftChild.rightChild.element.toString(),670, 20+(down*3));
						g.setColor(Color.black);
					}
				}
				
				if(rbTree.rootNode.rightChild.rightChild != null) {
					g.drawLine(700, 30+down, 800, down*2);
					if(rbTree.rootNode.rightChild.rightChild.color != null && rbTree.rootNode.rightChild.rightChild.color.equals(Color.black))
						g.setColor(Color.black);
					else if(rbTree.rootNode.rightChild.rightChild.color != null && rbTree.rootNode.rightChild.rightChild.color.equals(Color.red))
						g.setColor(Color.red);
					g.drawString(rbTree.rootNode.rightChild.rightChild.element.toString(),800, 20+(down*2));
					g.setColor(Color.black);
					
					if(rbTree.rootNode.rightChild.rightChild.leftChild != null) {
						g.drawLine(800, 30+(down*2), 710, down*3);
						if(rbTree.rootNode.rightChild.rightChild.leftChild.color != null && rbTree.rootNode.rightChild.rightChild.leftChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.rightChild.rightChild.leftChild.color != null && rbTree.rootNode.rightChild.rightChild.leftChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.rightChild.rightChild.leftChild.element.toString(),710, 20+(down*3));
						g.setColor(Color.black);
					}
					
					if(rbTree.rootNode.rightChild.rightChild.rightChild != null) {
						g.drawLine(800, 30+(down*2), 890, down*3);
						if(rbTree.rootNode.rightChild.rightChild.rightChild.color != null && rbTree.rootNode.rightChild.rightChild.rightChild.color.equals(Color.black))
							g.setColor(Color.black);
						else if(rbTree.rootNode.rightChild.rightChild.rightChild.color != null && rbTree.rootNode.rightChild.rightChild.rightChild.color.equals(Color.red))
							g.setColor(Color.red);
						g.drawString(rbTree.rootNode.rightChild.rightChild.rightChild.element.toString(),890, 20+(down*3));
						g.setColor(Color.black);
					}
				}
			}
		}
		
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Balanced Red Black Tree GUI");
		final BalancedGUI treeG = new BalancedGUI();
		JLabel label = new JLabel("This is 4 level tree. More than 4 level cannot be implemented.");
		label.setBounds(500, 400, label.getWidth(), label.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(treeG);
		
		//add buttons
		JButton addElement = new JButton("Add element");
		addElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				element = elementInput.getText();
				treeG.addElement(element);
			}
		});
		
		//remove buttons
		JButton removeElement = new JButton("Remove element");
		removeElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				element = elementInput.getText();
				treeG.removeElement(element);
			}
		});

		panel.add(label);
		panel.add(elementInput);
		panel.add(addElement);
		panel.add(removeElement);
		
		frame.add(panel, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
		
	}

}
