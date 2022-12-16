package pro;
/*
 * This class implements DequeADT<E>
 * This class should operate in O(1)
 * Therefore it has doubly linked list behavior with queue implements
 * It has few methods to help it acting like queue.
 * 
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.soap.Node;

public class ArrayDeque<E> implements DequeADT<E>{
	
	int numElement;
	NodeS<E> frontNode;
	NodeS<E> rearNode;
	
	//constructor of this class
	public ArrayDeque() {
		numElement = 0;
		frontNode = null;
		rearNode = null;
	}
	
	public ArrayDeque(Collection<? extends E>c) {
		this();
		for(E element: c)
			enqueueRear(element);
	}


	//adding elements from the rear of the node.
	@Override
	public void enqueueRear(E element) {
		NodeS<E> newNode = new NodeS<E>(element);
		
		if(rearNode == null) {
			frontNode = newNode;
			rearNode = newNode;
		}
		else{

			rearNode.next = newNode;
			rearNode = newNode;
		}
		numElement++;
	}
	
	//remove an element from the front of the element
	@Override
	public E dequeueFront() throws NoSuchElementException{
		if(frontNode != null) {
			E frontElement = frontNode.element;
			frontNode = frontNode.next;
			numElement--;
			if(numElement == 0) {
				rearNode = null;
			}
			return frontElement;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	//return the first element
	@Override
	public E first() throws NoSuchElementException{
		if(numElement > 0) {
			return frontNode.element;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	//return the last element
	@Override
	public E last() {
		if(numElement > 0) {
			return rearNode.element;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	//add element from the front
	@Override
	public void enqueueFront(E element) {
		NodeS<E> newNode = new NodeS<E>(element);
		if(frontNode == null) {
			frontNode = newNode;
			rearNode = newNode;
		}
		else{
			frontNode.prev = newNode;
			frontNode = newNode;
		}
		++numElement;
	}
	
	//remove element from the last of the queue
	@Override
	public E dequeueRear() throws NoSuchElementException{
		if(rearNode != null) {
			E rearElement = rearNode.element;
			rearNode = rearNode.prev;
			numElement--;
			if(numElement == 0) {
				rearNode = null;
			}
			return rearElement;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	//return true if empty
	@Override
	public boolean isEmpty() {
		return (numElement==0);
	}

	//return the number of elements
	@Override
	public int size() {
		return numElement;
	}

	//iterate all items all over
	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator<E>(frontNode);
	}

	//print currentNode to string
	@Override
	public String toString() {
		String output = "[";
		NodeS currentNode = frontNode;
		while(currentNode != null) {
			output += currentNode.element;
			if(currentNode.next != null)
				output += ",";
			currentNode = currentNode.next;
		}
		output += "]";
		return output;
	}
	

}
