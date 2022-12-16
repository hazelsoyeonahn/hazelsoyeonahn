
public class ArrayDeueue<E> implements DequeueADT<E>{
	 private E[] Ar;
     private int size = 0;
     private int increment = 100;

     public ArrayDeueue(int n) {
             Ar = (E[]) new Object[n];
             size = 0;
     }

     private void resize() {
             // create a new array with capacity of the old plus increment
             E[] temp = (E[]) new Object[Ar.length + increment];
             // copy all elements of the old array into the new one
             for (int i = 0; i < size; i++) {
                     temp[i] = Ar[i];
             }
             // assign new array to old array.
             Ar = temp;
     }

     @Override
     public void enqueueRear(E element) {
             if (size == Ar.length) {
                     resize();
             }

             Ar[size] = element;
             size++;

     }

     @Override
     public E dequeueFront() {
             if (this.isEmpty()) {
                     System.out.println("The array is emtpy");
                     return null;
             }
             E temp = Ar[0];
             for (int i = 1; i < size; i++) {
                     Ar[i - 1] = Ar[i];
             }
             size--;
             return temp;
     }

     @Override
     public E first() {
             // TODO Auto-generated method stub
             return null;
     }

     @Override
     public void enqueueFront(E element) {
             if (size == Ar.length) {
                     resize();
             }

             for (int i = size; i > 0; i--) {
                     Ar[i] = Ar[i - 1];
             }

             Ar[0] = element;
             size++;

     }

     @Override
     public E dequeueRear() {
             if (this.isEmpty()) {
                     System.out.println("The array is emtpy");
                     return null;
             }
             E temp = Ar[size - 1];
             size--;
             return temp;
     }

     @Override
     public E last() {
             if (size >= 0) {
                     E ele = Ar[size];
                     return ele;
             }
             return null;

     }

     @Override
     public boolean isEmpty() {
             return (size == 0);
     }

     @Override
     public void clear() {

             Ar = (E[]) new Object[1];
             size = 0;

     }

     @Override
     public int size() {
             return size;
     }

}

