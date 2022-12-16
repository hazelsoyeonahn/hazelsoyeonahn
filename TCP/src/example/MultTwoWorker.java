package example;

import java.util.Observable;
import java.util.Observer;

public class MultTwoWorker extends Worker implements Observer,Runnable{

	public MultTwoWorker() {
		super();
	}
	
	//let thread sleep
	@Override
	public void process(Task task) {
		//connect 2nd queue with outbox worker
		NotificationQueue secondQueue = new NotificationQueue(); //this queue only allows one task
		AddOneWorker outboxWorker = new AddOneWorker();
		secondQueue.addObserver(outboxWorker);
		System.out.println("Adding processed task to 2nd queue");
		secondQueue.setTask(task);		
	}
	
	//double the task value
	@Override
	public void processStep(Task task) {
		task.value*=2;
	}

	@Override
	public void requestStop() {
		System.out.println("Stopping request");
		executor.shutdownNow();
	}

	@Override
	public void update(Observable o, Object task) {
		this.currentTask = ((Task) task); //save received task object
		executor.execute(this); //this method will execute run method
		executor.shutdown(); 
		while(!executor.isTerminated()) {
		}
		System.out.println("Finished all threads, now add this task to 2nd queue");
		process(currentTask); //giving thread to other queue
	}
	
	//Thread pool
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" (Start) task identifier = "+currentTask.identifier+" value: "+currentTask.value);
		processStep(currentTask);
		System.out.println(Thread.currentThread().getName()+" (End)");
	}
}
