package pro;
import java.util.Collection;

public class DequeTest {
	public static void main(String args[]) {
		
		ArrayDeque a = new ArrayDeque();
		
		//Butter, Kenny, Stan has been added to rear of the queue
		a.enqueueRear("Butter");
		a.enqueueRear("Kenny");
		a.enqueueRear("Stan");
		
		//Butter and Kenny has been removed
		a.dequeueFront();
		a.dequeueFront();
		
		//Marry and Kurt
		a.enqueueFront("Marry");
		a.enqueueFront("Kurt");
		
		a.dequeueRear();
		a.dequeueRear();
		
		
		
	}

}
