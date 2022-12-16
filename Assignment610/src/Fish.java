/**
 * This class is the ball class which controls the balls.
 * This Ball class implemented Runnable interface.
 * The constructor for Ball includes x,y axis, JComponent, speed of x,y
 * move method contols the ball movements
 * draw method draws the ball
 * there is a override run method for runnable interface.
 */

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;

public class Fish implements Runnable{
	
	//attributes
	private int x, y, diameter, xSpeed, ySpeed;
	private JComponent component;
	private Color color;
	
	//constructor
	
	public Fish(FishShoal fish) {
		
	}
	/*public Fish(int x, int y, JComponent component, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.component = component;
		diameter = 25;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}*/
	
	//method to move ball
	public void move() {
	//to make x direction in a range
		if(x<0|| (x+diameter) > component.getWidth()) {
			xSpeed = -xSpeed;
		}

	//to make y direction in a range
		if(y<0|| (y+diameter) > component.getHeight()) {
			ySpeed = -ySpeed;
		}
	//add velocity
		x += xSpeed;
		y += ySpeed;
	}
	
	//method to draw ball
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, diameter, diameter);
	}
	
	//method to call when ball thread has been thrown
	@Override
	public void run() {
		//looping for thread
		
		while(true) {
			//move ball
			move();
			//paint ball
			component.repaint();
			//pauce
			try {
				Thread.sleep(60);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
