package ex6_2;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Exercise 6.2
 * This class has an algorithm of depthFirstSearch
 * Rather than using an explicit stack, 
 * it uses a recursive version of depthFirstSearch method
 */

public class DepthFirstSearch {
	private int numVertex;
	private LinkedList<Integer> list[];
	private boolean visited[];
	
	//constructor to build the list 
	public DepthFirstSearch(int numVertex) {
		this.numVertex = numVertex;
		list = new LinkedList[numVertex];
		visited = new boolean[numVertex];
		
		for(int i=0; i<numVertex; i++) {
			list[i] = new LinkedList();
		}
	}
	
	//add edges between vetexes
	public void addEdge(int vertex1, int vertex2) {
		list[vertex1].add(vertex2);
	}
	
	//recursive depth first search method
	public void depthFirstSearch(int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		Iterator<Integer> i = list[vertex].listIterator();
		
		while(i.hasNext()) {
			int number = i.next();
			if(!visited[number])
				depthFirstSearch(number);
		}
	}
	
	public static void main(String args[]) {
		//declare 4 vertices
		DepthFirstSearch d = new DepthFirstSearch(4);
		
		//add edges between vertices
		d.addEdge(0, 1);
		d.addEdge(0, 2);
		d.addEdge(1, 2);
		d.addEdge(2, 0);
		d.addEdge(2, 3);
		
		System.out.println("This depth search method start from the vertex 2");
		//call depth first search method
		d.depthFirstSearch(2);
		
	}

	
	
}
