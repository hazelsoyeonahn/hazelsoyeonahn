
public interface DequeueADT<E> {
	 void enqueueRear(E element);

     E dequeueFront();

     E first();

     void enqueueFront(E element);

     E dequeueRear();

     E last();

     boolean isEmpty();

     void clear();

     int size();

}
