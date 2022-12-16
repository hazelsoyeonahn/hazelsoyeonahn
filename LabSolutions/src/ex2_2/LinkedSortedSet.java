package ex2_2;

import java.util.LinkedList;

public class LinkedSortedSet extends LinkedList<Element>{
	
	public void addElement(int n) {
		Element e = new Element(n);
		
		//when list is empty
		if(this.size() == 0) {
			this.addFirst(e);
			return;
		}
		
		for(int i=0; i<this.size(); i++) {
			if(e.compareTo(this.get(i))==1)
				continue;
			else {
				this.add(i,e);
				return;
			}
		}
		this.addLast(e);
	}
	
	public void print() {
		for(int i=0; i<this.size(); i++) {
			System.out.println(this.get(i).value);
		}
	}
	
	public static void main(String[] args) {
		LinkedSortedSet list = new LinkedSortedSet();
		list.addElement(52);
		list.addElement(2);
		list.addElement(24);
		list.addElement(62);
		list.addElement(34);
		list.addElement(82);
		list.print();
	}
}
