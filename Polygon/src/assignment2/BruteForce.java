package assignment2;
/*
 * This class implements Brute Force strategy. 
 * It calls getLine if n < 7 and calls recursiveLine when n <= 7.
 * Because when n is equal or bigger than 7, it needs recursive approach.
 * Both method returns the collection of array of vertices' index without duplication.
 * Then it starts to draw lines and calculate length of each polygons.
 * Finally, it will find the smallest sum of edge length.
 */

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BruteForce extends JPanel{
	int n;
	int nonInterEdge;
	int triangle;
	int totalInterEdge;
	int[][] vertex;
	
	//constructor	
	public BruteForce(int n, int[][] vertex) {
		JLabel label = new JLabel();
		this.n = n;
		this.nonInterEdge = n - 3;
		this.triangle = n - 2;
		this.totalInterEdge = (n*(n-3))/2;
		this.vertex = new int[n][n];
		this.vertex = vertex;	
		label.setText("Non Inter Edge: "+nonInterEdge+" , Number of triangle: "+triangle+", Total Inter Edge: "+totalInterEdge);
		super.add(label);
	}
	
	public BruteForce() {
	}
	
	//indicate opposite vertex for a base triangle
	public int getOpp(int vertex) {
		int opp = vertex;
		return opp;
	}
	
	//get left side of vertex
	public int popLeft(int vertex) {
		if(vertex == n-1)
			return 0;
		return vertex+1;
	}
	
	//get right side of vertex
	public int popRight(int vertex) {
		if(vertex == 0)
			return n-1;
		return vertex-1;
	}
	
	//get new set of stack with all vertex
	public Stack getNewStack() {
		Stack s = new Stack();
		for(int i=0; i<n; i++)
			s.push(i);		
		return s;
	}
	
	//recursively calls getLine method. 
	//This method can iterate remaining stacks after call getLine.
	public Queue<ArrayList> recursiveLine(){
		int oriN = n; //save original n
		int v0 = 0;
		int v2 = 2;
		int vi = 0;
		int count = 0;
		n = oriN-1; //fake n = oriN-2 for recursion
		//then recursively call getLine
		Queue<ArrayList> returned = getLine();
		Queue<ArrayList> returnThis = new LinkedList<ArrayList>();
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		while(v0 != oriN) {
			for(ArrayList arr: returned) {
				newArr.add(v0);
				newArr.add(v2);
				ArrayList<Integer> tes = arr;
				for(int i=0; i< tes.size(); i++) {
					int modified = tes.get(i)+2+count;
					if(modified >= oriN)
						modified -= n;
					newArr.add(modified);
				}
				returnThis.add(newArr);
				newArr = new ArrayList<Integer>();
			}
		v0++;
		v2++;
		if(v2 == oriN)
			v2 = 0;
		count++;
		n = oriN;
		}
		System.out.println(returnThis);
		return returnThis;
	}
	
	//method to get all possible combination of lines for the polygon
	public Queue<ArrayList> getLine(){
		Stack s = new Stack();
		ArrayList<Integer>[] arr = new ArrayList[n*2];
		int v0 = 0;
		int v2 = 2;
		int  vi = 0; //initial vertex always start from 0
		int opp = 0; //get connected vertex from base triangle
		int arrNum = 0;
		//if square, there are only 2 cases.
		if(n == 4) {
			for(int i=0; i<2; i++) {
				arr[i] = new ArrayList();
				arr[i].add(v0+i);
				arr[i].add(v2+i);
			}
		}

		//if more than 7 vertex, it needs more function such as recursiveLine method
		//iterate from v0 to end vertex
		while(v0!=n && n > 4 &&n < 7) {
			//check all case of v0 and v2
			vi = v0;
			for(int i=0; i<2; i++) {
				s = getNewStack();
				arr[arrNum] = new ArrayList();
				if(vi == v0)
					opp = v2;
				if(vi == v2)
					opp = v0;
				
				//remove all unavailable element to connect
				s.removeElement(popLeft(vi));
				s.removeElement(popRight(vi));
				s.removeElement(vi);
				s.removeElement(opp);
			
				//add it to the array
				arr[arrNum].add(v0);
				arr[arrNum].add(v2);
				
				while(!s.empty()) {
					arr[arrNum].add(vi);
					arr[arrNum].add((int)s.pop());
				}
				
				++arrNum;
				vi = v2;
			}
			v0++;
			v2++;
			if(v2 >= n)
				v2 = 0;
		}
		System.out.println("ArrayList of possible tessellation before sorting:");
		for(int i=0; i<n*2; i++) {
			System.out.println(arr[i]);
		}
		
		Queue<ArrayList> returnThis = new LinkedList<ArrayList>();	
		for(int i=0; i<n*2; i++) {				 
			 for(int j=0; j<n*2; j++) {
				 //if the array is not same object ignore it
				 if(arr[i] != null&&arr[j]!=null) {
					 if(arr[i].equals(arr[j])) {
					 }
					 else {
						 //if array contains same elements make it null
						if(arr[i].containsAll(arr[j])) {
							arr[j] = null;
						}
					 }	 	 
				 }
			 }
		}
		for(int i=0; i<n*2; i++) {
			//ignore null values that were duplicates.
			if(arr[i] != null)
				returnThis.add(arr[i]);
		}
		System.out.println("Array of tessellation without duplication:");
		System.out.println(returnThis);	
		return returnThis;
	}
	//paint JPanel
	public void paintComponent(Graphics g) {
		int nextPoly = 0;
		int linePoly = 0;
		int countPos = 0;
		int totalLength = 0;
		ArrayList<Integer> findMin = new ArrayList<Integer>();
		super.paintComponent(g);
	//triangle doesn't need lines
	if(n > 3) {
		Queue<ArrayList> returned = getLine();
		if(n>=7) {returned = recursiveLine();} //if more than 7 vertices, recursive method is called

		//all possible lines are returned here
		for(ArrayList arr: returned) {
			ArrayList<Integer> tes = arr;
			Polygon p = new Polygon();
			
			//draw polygon
			for(int j=0; j<n; j++) {
				p.addPoint(vertex[j][0]+nextPoly, vertex[j][1]+linePoly);
			}
			g.drawPolygon(p);
			
			//add lines
			for(int k=0; k<tes.size(); k++) {
				g.drawLine(vertex[(int)(tes.get(k))][0]+nextPoly, vertex[(int)(tes.get(k))][1]+linePoly,
						vertex[(int)(tes.get(k+1))][0]+nextPoly, vertex[(int)(tes.get(k+1))][1]+linePoly);
				
				//Pythagoras theorem for calculating length of each lines.
				int x1 = vertex[(int)(tes.get(k))][0];
				int x2 = vertex[(int)(tes.get(k+1))][0];
				int y1 = vertex[(int)(tes.get(k))][1];
				int y2 = vertex[(int)(tes.get(k+1))][1];
				int length =+ ((int) Math.sqrt((Math.abs(y2 - y1)*Math.abs(y2 - y1))+(Math.abs(x2 - x1)*Math.abs(x2-x1))));
				totalLength += length;
				k++;
			}
			findMin.add(totalLength); //add length to the arrayList
			g.drawString("length: "+totalLength,70+nextPoly, 160+linePoly);
			totalLength = 0;
			++countPos;
			nextPoly += 200; //move position of polygon
			if(countPos % 4 == 0) {
				nextPoly = 0;
				linePoly += 150;				
			}
		}
		Integer min = Collections.min(findMin); //find minimum length
		System.out.println("Smallest total edge length is "+min);
		g.drawString("Smallest total edge length is: "+min, 20, 20);
	}
	//if triangle there are no line
	else {
			Polygon p = new Polygon();
		
			//draw polygon
			for(int j=0; j<n; j++) {
				p.addPoint(vertex[j][0]+nextPoly, vertex[j][1]+linePoly);
			}
			g.drawPolygon(p);
			g.drawString("Triangle has no line",300, 300);
		}
	}
}
