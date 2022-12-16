package pro;

//this code is from the book

import java.util.Iterator;
import java.util.NoSuchElementException;
//inner class which represents an iterator for a singly-linked list
public class LinkedIterator<E> implements Iterator<E>{
	private NodeS<E> nextNode; //next node to use for the iterator
	
	//constructor which accepts a reference to first node in list
	//and prepares an iterator which will iterate through the 
	//entire linked list
	public LinkedIterator(NodeS<E> firstNode) {
		nextNode = firstNode; //start with first node in list
	}

	//returns whether there is still another element
	@Override
	public boolean hasNext() {
		return (nextNode!=null);
	}

	//returns the next element or throws a NoSuchElementException
	//it there are no further elements
	@Override
	public E next() throws NoSuchElementException{
		if(!hasNext())
			throw new NoSuchElementException();
		E element = nextNode.element;
		nextNode = nextNode.next;
		return element;
	}
	
	//remove method not supported by this iterator
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
