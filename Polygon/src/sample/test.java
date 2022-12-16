package sample;

import java.util.Stack;

public class test {
	static int n = 5; //5 vertices
	
	public static int getPairV(int vertex) {
		if(vertex+2 > n)
			return vertex+2-n;
		return vertex+2;
	}
	
	public static int popLeft(int vertex) {
		if(vertex == n-1)
			return 0;
		return vertex+1;
	}
	
	public static int popRight(int vertex) {
		if(vertex == 0)
			return n-1;
		return vertex-1;
	}
	
	public static void main(String args[]) {
		int vi = 0;
		
		Stack s = new Stack();
		for(int i=0; i<n; i++)
			s.push(i);
		System.out.println(s);
		
		s.removeElement(popLeft(vi));
		System.out.println(s);
		
		s.removeElement(popRight(vi));
		System.out.println(s);
		
		s.removeElement(vi);
		System.out.println(s);
		
		s.removeElement(getPairV(vi));
		System.out.println(s);
	}
}
