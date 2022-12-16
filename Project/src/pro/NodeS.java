package pro;

public class NodeS<E> {
	public E element;
	public NodeS<E> next;
	public NodeS<E> prev;
	
	public NodeS(E element) {
		this.element = element;
		next = null;
		prev = null;
		}
	}
