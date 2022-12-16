package tcp;
/*
 * This worker class is an abstract class and parent class of MultTwoWorker and AddOneWorker.
 * As worker can process only one task at a time, ExcutorService is implemented here.
 * The executor implements a newFixedThreadPool which process limited 1 thread at a time. 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Worker{
	protected Task currentTask;
	public ExecutorService executor = Executors.newFixedThreadPool(1);
	public Runnable worker;
	boolean loop = false;

	
	//constructor
	public Worker() {
		this.currentTask = new Task();
	}
	
	//abstract method that passes a Task to one available thread for processing
	public abstract void process(Task task); 
	//perform the processing step
	public abstract void processStep(Task task);
	//terminating the Worker thread
	public abstract void requestStop();
	
	//this main method can test the functionality of worker class
	public static void main(String args[]) {
		MultTwoWorker mult = new MultTwoWorker();
		AddOneWorker one = new AddOneWorker();
		Task t = new Task();
		
		t.identifier = 2;
		
		System.out.println("Testing MultTwoWorker");
		System.out.println("task value: "+t.value);
		System.out.println("double the value");
		mult.processStep(t);
		System.out.println("task value: "+t.value);
		
		//when queue is added it will invoke update for next worker
		System.out.println("\nAdd it to the queue");
		mult.process(t);

		//this will work with threads
		System.out.println("\nRequest to stop process");
		mult.requestStop();
		
		System.out.println("Testing AddOneWorker");
		System.out.println("task value: "+t.value);
		System.out.println("add one to the value");
		one.processStep(t);
		System.out.println("task value: "+t.value);
		System.out.println("Request to stop process");
		mult.requestStop();
	}
}
