package pro;

import java.util.Iterator;
import java.util.Random;

public class LinkedBag<E> implements Bag<E> {
	
	int capacity;
	int position;
	Random r = new Random();
	
	E[] bag;
	NodeL<E> firstNode, lastNode= null;
	
	public LinkedBag(){
		capacity = 10;
		position = 0;
}	
	public LinkedBag(int capacity) {
		this.capacity = capacity;
		position = 0;
	}
	
	//add item if it can fit it.
	@Override
	public boolean add(E item) {
		if(isEmpty()) {
			return false;
		}
		else {
		NodeL newNode = new NodeL(item, firstNode, null);
        if(firstNode != null ) {
        	firstNode.prev = newNode;}
        firstNode = newNode;
        if(lastNode == null) {
        	lastNode = newNode;}
        position++;
        System.out.println("adding: "+item);
        
        return true;	
		}
	}

	@Override
	public E grab() {
		int index = r.nextInt((position - 0) + 1);
		NodeL<E> currentNode = null;
		NodeL<E> movingNode = null;
		if (index == 1) {
			currentNode = firstNode;
		}
		else {
			for(int i=0; i<index; ++i) {
			firstNode.next = currentNode;
			firstNode = firstNode.next;
			}	
		}
	
		return (E)currentNode;
	}

	@Override
	public boolean remove(E item) {
		NodeL<E> removeNode = firstNode;
		for(int i = 0; i < capacity; i++) {
			firstNode.next = removeNode;
			firstNode = firstNode.next;
			
			if(removeNode.equals(item)) {
				firstNode = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		int size = 0;
		NodeL<E> sizeNode = firstNode;
		for(int i = 0; i < capacity; i++) {
			firstNode.next = sizeNode;
			firstNode = firstNode.next;
			++size;
		}
		return size;
	}

	@Override
	public int capacityRemaining() {
		return capacity - size();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public Iterator<E> iterator() {
        NodeL newNode = firstNode;
        while(newNode != null){
            System.out.println(newNode.element);
            newNode = newNode.next;
        }
		return null;
	}

	@Override
	public E[] toArray() {
		return null;
	}

}
