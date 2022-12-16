package tcp;
/*
 * The Demonstration class explains how this application is running.
 */

public class Demonstration {
	public static void main(String args[]) {
		System.out.println("This application is built by Hazel Ahn by herself\n");
		System.out.println("This program has one client output task and received processed task.");
		System.out.println("Please connect to the ProcessServer first.");
		System.out.println("Then, please run Client class to make connection with ProcessServer");
		System.out.println("Please input integer identifier for the task from Client console");
		System.out.println("It will add task to the queue, then notify the observer to process the task");
		System.out.println("The queue will be reused everytime the worker processed work then add it back to the queue");
		System.out.println("If task meet all the workers and processsed, it will notify ProcessServer");
		System.out.println("Notified ProcessServer will output the final task to the client");
		System.out.println("Then your program is finished and will be terminated");
		System.out.println("\nUnfortunetly, I had trouble putting multiple tasks");
		System.out.println("When I tried to run multiple threads, the program was keep crashing. But it works perfect, except having cuncurrent tasks");
		System.out.println("So, decide to submit a program that works well rather than submit a program with threads running around with errors");
		System.out.println("Thank you for reading.");
	}
}
