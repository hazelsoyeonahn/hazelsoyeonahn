package tcp;
/*
 * This task class is a base class that holds an identifier for this task.
 * An integer value 7 will be manipulated by workers.
 * 
 */

public class Task{
	int identifier; //task identifier
	int value; //value of this task
	
	public Task() {
		this.value = 8;
	}


}
