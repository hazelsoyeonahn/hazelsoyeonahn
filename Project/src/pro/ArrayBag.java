package pro;

import java.util.Iterator;
import java.util.Random;

public class ArrayBag<E> implements Bag<E>{
	
	int capacity;
	int position = -1;
	
	E[] bag;
	
	public ArrayBag(){
		capacity = 10;
		bag = (E[]) new Object[capacity];

}	
	public ArrayBag(int capacity) {
		this.capacity = capacity;
		bag = (E[]) new Object[capacity];
	}
		
		
	
	//generate random index for an item.
	Random r = new Random();
	
	@SuppressWarnings({ "unchecked" })

	//add item if it can fit it.
	public boolean add(E item) {
		if (isFull()) {
			System.out.println("Cannot add an item. The bag is full.");
			return false;
		}
		else {
			bag[++position] = item;
			System.out.println("Item added");
			
			return true;
		}
	}

	//The only way to get an item in the bag
	//,which gives back an item in the bag at random.
	public E grab() {
		int index = r.nextInt((position - 0) + 1);
		
		return bag[index];
	}
	
	//remove a specific item from the bag.
	@SuppressWarnings("unused")
	public boolean remove(E item) {
		for(int i = 0; i < capacity; i++) {
			if(bag[i].equals(item)) {
				bag[i] = null;
				System.out.println("Item removed");
				return true;
			}
		}
		System.out.println("Item not found");
		return false;
	}
	
	//giving the number of items in the bag
	public int size() {
		int count = 0;
		for(int i=0; i< capacity; i++) {
			if(bag[i] != null) {
				++count;
			}
		}
		return count;
	}

	//returns how many items can still be added to bag
	//before it is full.
	public int capacityRemaining() {
		int count = 0;
		for(int i=0; i< capacity; i++) {
			if(bag[i] == null) {
				++count;
			}
		}
		return count;
	}

	//return true if the bag is full
	public boolean isFull() {
		return position == bag.length;
	}

	//return true if the bag is empty
	public boolean isEmpty() {
		int count = 0;
		for(int i = 0; i<capacity; i++) {
			if(bag[i] == null) {
				count++;
			}
		}
		if (count == 10) {
			return true;
		}
		return false;
	}

	//removes all items from the bag.
	public void clear() {
		for(int i=0; i < position; ++i) {
			bag[i] = null;
		}
		System.out.println("Your bag is cleared");
	}

	//allows items to be iterated over
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(bag,position);
	}

	//returns an array of the same type of all items left
	//in the bag.
	public E[] toArray() {
		E[] returnThis = (E[]) new Object[capacity];
		int count = 0;
		
		for(int i=1; i < position; ++i) {
			if(bag[0].getClass().equals(bag[i].getClass())) {
				returnThis[0] = bag[0];
				returnThis[count++] = bag[i];
			}
		}
		return returnThis;
	}
}
