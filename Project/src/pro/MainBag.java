package pro;

import java.util.Scanner;

public class MainBag {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//instantiate ArrayBag with fixed capacity.
		ArrayBag a = new ArrayBag();
		
		//instantiate ArrayBag with user dependent capacity.
		ArrayBag b = new ArrayBag(30);
		
		
		//starting with fixed capacity test.
		//generate some different types of items.
		Object a1 = new String();
		int a2;
		Object a3 = new String();
		int a4;
		float a5;
		String a6;
		

		a1 = "hi";
		a2 = 5;
		a3 = "happy";
		a4 = 71;
		a5 = 0.1F;
		a6 = "Thanks";

		//add items.
		System.out.println("Adding items...");
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		a.add(a5);
		a.add(a6);

		
		//grab a random item.
		System.out.println("\nGrab a random item...");
		System.out.print(a.grab());
		
		//remove a specific item.
		System.out.println("\n\nRemoving specific item...");
		//a.remove(o1);
	
		//get the size of items.
		System.out.println("\nGetting the number of items...");
		System.out.print(a.size());
		
		//get the remaining capacity
		System.out.println("\n\nGetting remaining capacity...");
		System.out.print(a.capacityRemaining());
		
		//you can check if bag is full when you add too much object in a bag.
		
		//check if bag is empty.
		System.out.println("\n\nChecking if bag is empty...");
		System.out.print(a.isEmpty());
		
		//clear all items in the bag.
		System.out.println("\n\nClearing all items...");
		//a.clear();
		
		//iterate your items all over.
		System.out.println("\nIterating all items all over...");
		a.iterator();
		
		//returns an array of the same type of all items left
		System.out.println("\nReturning same type of items");
		a.toArray();
		
		
		//using second constructor;
		Object b1 = new String();
		int b2;
		Object b3 = new String();
		int b4;
		float b5;
		String b6;
		

		b1 = "hi";
		b2 = 5;
		b3 = "happy";
		b4 = 71;
		b5 = 0.1F;
		b6 = "Thanks";

		//add items.
		System.out.println("Adding items...");
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		b.add(b5);
		b.add(b6);

		
		//grab a random item.
		System.out.println("\nGrab a random item...");
		System.out.print(b.grab());
		
		//remove a specific item.
		System.out.println("\n\nRemoving specific item...");
		//a.remove(b1);
	
		//get the size of items.
		System.out.println("\nGetting the number of items...");
		System.out.print(b.size());
		
		//get the remaining capacity
		System.out.println("\n\nGetting remaining capacity...");
		System.out.print(b.capacityRemaining());
		
		//you can check if bag is full when you add too much object in a bag.
		
		//check if bag is empty.
		System.out.println("\n\nChecking if bag is empty...");
		System.out.print(b.isEmpty());
		
		//clear all items in the bag.
		System.out.println("\n\nClearing all items...");
		//b.clear();
		
		//iterate your items all over.
		System.out.println("\nIterating all items all over...");
		b.iterator();
		
		//returns an array of the same type of all items left
		System.out.println("\nReturning same type of items");
		b.toArray();
		
		//trying Doubly Linked List Bag
		LinkedBag c = new LinkedBag();
		
		//starting with fixed capacity test.
		//generate some different types of items.
		Object c1 = new String();
		int c2;
		Object c3 = new String();
		int c4;
		float c5;
		String c6;
		

		c1 = "hi";
		c2 = 5;
		c3 = "happy";
		c4 = 71;
		c5 = 0.1F;
		c6 = "Thanks";
		
		//add items.
		System.out.println("Adding items...");
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		

	}

}
