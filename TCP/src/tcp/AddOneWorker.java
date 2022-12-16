package tcp;

import java.util.Observable;
import java.util.Observer;

public class AddOneWorker extends Worker implements Observer,Runnable{
	NotificationQueue thirdQueue;
	
	public AddOneWorker() {
		super();
	}

	@Override
	public void process(Task task) {
		//connect 3rd queue with final task output
		//the server will observe if anything is in the queue.
		thirdQueue = new NotificationQueue();
		ProcessServer receiver = new ProcessServer();
		thirdQueue.addObserver(receiver);
		System.out.println("Adding final task to 3rd queue");
		thirdQueue.setTask(task);
	}

	//add one to the value
	@Override
	public void processStep(Task task) {
		task.value+=1;	
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
		System.out.println("Finished all threads, now add this task to 3rd queue");
		process(currentTask);
	}

	//Thread pool, limited to one thread
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" (Start) task identifier = "+currentTask.identifier+" value: "+currentTask.value);
		processStep(currentTask);
		System.out.println(Thread.currentThread().getName()+" (End)");	
	}
}
