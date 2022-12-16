package tcp;
/*
 * This notification queue class has AbstractQueue get task input
 * This class is reused by multiple workers. 
 * It simply adds task from parameter and notify observers
 */
import java.util.AbstractQueue;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationQueue extends Observable{
	AbstractQueue<Task> queue; //receiving task thread

	public NotificationQueue() {
		this.queue = new LinkedBlockingQueue<Task>();
	}
	
	//remove specific observer for this queue
	public void removeObserver(NotificationQueue q,Observer o) {
		q.deleteObserver(o);
	}
	
	//add specific observer for this queue
	public void addObserver(NotificationQueue q,Observer o) {
		q.addObserver(o);
	}
	
	//add task to the queue, save the change then notify observers.
	public void setTask(Task task) {
		queue.add(task); //add the task to queue
		setChanged();
		notifyObservers(queue.poll()); //if queue has been changed, notify observers
	}
	
	//this main mathod test the functionality of this NotificationQueue class
	public static void main(String args[]) {
		MultTwoWorker worker = new MultTwoWorker();
		NotificationQueue q = new NotificationQueue();
		Task t = new Task();
		
		System.out.println("Testing NotificationQueue class");
		System.out.println("Add MultTwoWorker observer for this queue");
		q.addObserver(q,worker);
		System.out.println("\nAdd a task to the queue, it will notify observer automatically");
		q.setTask(t);
		System.out.println("\nRemove observer");
		q.removeObserver(q,worker);
	}
}
