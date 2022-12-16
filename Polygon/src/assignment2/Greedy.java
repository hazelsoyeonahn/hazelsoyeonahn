package assignment2;
/*
 * Greedy class implements Approximate Greedy Approach.
 * The class uses Brute Force Search to find the smallest length.
 * Then print out the polygon with smallest length.
 * If triangle, it will only print polygon.
 */
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Greedy extends JPanel{
	int n;
	int[][] vertex;
	int nonInterEdge;
	int triangle;
	int totalInterEdge;
	Integer min;
	//constructor
	public Greedy(int n, int[][] vertex) {
		JLabel label = new JLabel();
		this.n = n;
		this.vertex = vertex;
		this.nonInterEdge = n - 3;
		this.triangle = n - 2;
		this.totalInterEdge = (n*(n-3))/2;
		label.setText("Non Inter Edge: "+nonInterEdge+" , Number of triangle: "+triangle+", Total Inter Edge: "+totalInterEdge);
		super.add(label);
	}
	
	//returns an array list of vertices with the smallest lengths lines.
	public ArrayList<Integer> getSmallest(){
		BruteForce br = new BruteForce(n,vertex);
		Queue<ArrayList> allPossible = new LinkedList<ArrayList>();
		ArrayList<Integer> returnMin = new ArrayList<Integer>();
		ArrayList<Integer> findMin = new ArrayList<Integer>();
		
		//directly call correct methods for n
		if(n<7) {allPossible = br.getLine();}
		if(n>=7) {allPossible = br.recursiveLine();}
		
		//find all length of lines for all cases
		int totalLength = 0;
		for(ArrayList arr: allPossible) {
			ArrayList<Integer> tes = arr;
			for(int k=0; k<tes.size(); k++) {
				//pythagoras
				int x1 = vertex[(int)(tes.get(k))][0];
				int x2 = vertex[(int)(tes.get(k+1))][0];
				int y1 = vertex[(int)(tes.get(k))][1];
				int y2 = vertex[(int)(tes.get(k+1))][1];
				int length =+ ((int) Math.sqrt((Math.abs(y2 - y1)*Math.abs(y2 - y1))+(Math.abs(x2 - x1)*Math.abs(x2-x1))));
				totalLength += length;
				k++;		
				}
			findMin.add(totalLength);
			totalLength = 0;
			}
		//find minimum length
		min = Collections.min(findMin);
		int index = findMin.indexOf(min);
		System.out.println("Smallest total edge length is "+min);
		int found = 0;
		//find the elements with the found minimum length
		for(ArrayList arr: allPossible) {
			returnMin = arr;
			//when minimum length found stop the loop
			if(found == index) {
				break;
			}
		}	
		return returnMin;
	}
	
	public void paintComponent(Graphics g) {
		Polygon p = new Polygon();
		ArrayList<Integer> minimum = new ArrayList<Integer>();
		//draw polygon
		for(int j=0; j<n; j++) {
			p.addPoint(vertex[j][0], vertex[j][1]);
		}
		g.drawPolygon(p);
		
		if(n>3) {		
			minimum = getSmallest();

			//print lines of a found polygon
			for(int k=0; k<nonInterEdge*2; k++) {
				g.drawLine(vertex[minimum.get(k)][0], vertex[minimum.get(k)][1],
						vertex[minimum.get(k+1)][0], vertex[minimum.get(k+1)][1]);
				k++;
			}
			g.drawString("length: "+min,70, 160);
		}
		//triangle doesn't need line
		else {
			g.drawString("Triangle has no line",300, 300);
		}
	}
}
