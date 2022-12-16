package ex1_3;
/*
 * This class implements Runnable interface to throw thread
 */

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Ball implements Runnable{
	
	private int x, y, diameter, xSpeed, ySpeed;
	private Color color;
	private JComponent j; //Jpanel 
	
	//constructor
	public Ball(int x, int y, int xSpeed, int ySpeed, JComponent j) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.j = j;
		diameter = 25;
	}
	
	public void move() {
		//make sure the ball is moving in the range
		if(x<0 || (x+diameter)>j.getWidth())
			xSpeed = -xSpeed;
		if(y<0 || (y+diameter)>j.getHeight())
			ySpeed = -ySpeed;
		
		x += xSpeed;
		y += ySpeed;
	}
	
	//draw the ball
	public void draw(Graphics2D g) {
		g.setColor(color.green);
		g.fillOval(x, y, diameter, diameter);
	}

	@Override
	public void run() {
		while(true) {
			move();
			
			j.repaint();
			try {
				Thread.sleep(70);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
