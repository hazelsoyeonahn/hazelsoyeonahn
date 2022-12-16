package pro;

public class NodeL<E> {
	public E element;
	public NodeL<E> next,prev;
	
	public NodeL(E element, NodeL<E> next, NodeL<E> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

}
