package ex1_3;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallGUI extends JPanel{
	private ArrayList<Ball> ballList;
	
	//constructor
	public BallGUI() {
		ballList = new ArrayList<Ball>();
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
	}

	//add a new ball
	public void addBall(int x, int y) {
		Ball b = new Ball((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()),x,y,this);
		ballList.add(b);
		Thread t = new Thread(b);
		t.start();
		t.notifyAll();
	}
	
	public void removeBall() {
		if(!ballList.isEmpty())
			ballList.remove(0);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		
		g.drawRect(0, 0, getWidth(), getHeight());
		for(Ball b: ballList) //keep draw ball when added
			b.draw(g2);
	}
	
	static int x = 4;
	static int y = 4;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		final BallGUI ballG = new BallGUI();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ballG);
		
		//add buttons
		JButton addBall = new JButton("Add ball");
		addBall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ballG.addBall(x, y);
			}
		});
		
		JButton removeBall = new JButton("Remove ball");
		removeBall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ballG.removeBall();
			}
		});
		
		JButton speedDown = new JButton("Speed down");
		speedDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 1;
				y -= 1;
			}
		});
		
		JButton speedUp = new JButton("Speed Up");
		speedUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 1;
				y += 1;
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(addBall);
		panel.add(removeBall);
		panel.add(speedUp);
		panel.add(speedDown);
		frame.add(panel, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
	}
	
}
