package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ProcessServer class uses a TCP server socket to accept Task from client 
 * and another TCP server socket to output task to clients. 
 * This server and Client class will communicate each other.
 * 
 */

public class ProcessServer implements Observer{
	private boolean stopRequested;
	public static final int PORT1 = 3433; //input port
	public static final int PORT2 = 4343; //output port
	public Task newTask;
	
	//constructor
	public ProcessServer() {
		stopRequested = false;
		this.newTask = new Task();
	}
	
	//start the server
	public void startServer() {
		stopRequested = false;
		ServerSocket inputServerSocket = null;
		ServerSocket outputServerSocket = null;
		
		//create a server Socket for input tasks from clients
		try {
			inputServerSocket = new ServerSocket(PORT1);
			System.out.println("Input Server started at "+ InetAddress.getLocalHost()+" on port "+ PORT1);
		}catch(IOException e) {
			System.out.println("Input Server can't listen on port: "+ e);
			System.exit(-1);
		}
		
		//create a server Socket for output tasks from clients
		try {
			outputServerSocket = new ServerSocket(PORT2); //port needs to be different
			System.out.println("Ouput Server started at "+ InetAddress.getLocalHost()+" on port "+ PORT2);
		}catch(IOException e) {
			System.out.println("Output Server can't listen on port: "+ e);
			System.exit(-1);
		}
		
		try {
			while(!stopRequested) {
				// block until the next client requests a connection
				
				//input socket
				Socket inputSocket = inputServerSocket.accept();
				System.out.println("Connection made with "+ inputSocket.getInetAddress());
				
				//output socket
				Socket outputSocket = outputServerSocket.accept(); //server socket needs to have own thread
				System.out.println("Connection made with"+ outputSocket.getInetAddress());
			
				//throw threads
				Inbox inbox = new Inbox(inputSocket);
				Outbox outbox = new Outbox(outputSocket);
				
				Thread in = new Thread(inbox);
				Thread out = new Thread(outbox);
				
				in.start();
				out.start();
			}
			inputServerSocket.close();
			outputServerSocket.close();
		}catch(IOException e) {
			System.err.println("Can't accpet client connection: "+ e);
		}
		System.out.println("Server finishing");
	}
	
	//controls clients request connections
	public void requestStop() {
		stopRequested = true;
	}
	
	//get task from client class
	public void getTask(Task task) {
		this.newTask = task;
	}
	
	//main method that starts the server
	public static void main(String[] args) {
		ProcessServer server = new ProcessServer();
		server.startServer();
	}
	
	//inner class for running an inbox thread
	public class Inbox implements Runnable{
		private Socket socket;
		private NotificationQueue inboxQueue;
		private MultTwoWorker inboxWorker;
		
		//constructor that add first worker observer for the queue.
		public Inbox(Socket socket) {
			this.socket = socket;
			this.inboxQueue = new NotificationQueue();
			this.inboxWorker = new MultTwoWorker();
			inboxQueue.addObserver(inboxWorker);
		}
		
		//run inbox threads
		@Override
		public void run() {
			BufferedReader br;
			PrintWriter pw;
			String clientAnswer = "";
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
				pw = new PrintWriter(socket.getOutputStream(), true);
				pw.println("Type identifier number for the task:");
				int id = 0; //task identifier
				do {
					clientAnswer = br.readLine();
					if(clientAnswer == null)
						pw.println("Nothing entered, try again");
					else {
						try {
							id = Integer.parseInt(clientAnswer);
							
						}catch(NumberFormatException e) {
							pw.println("Enter integer");
						}
					
						//pass task object add to the queue
						newTask.identifier = id; //set identifier
						inboxQueue.setTask(newTask); //queue Task					
					}
				}while(clientAnswer.equals("quit"));
				br.close();
				System.out.println("Closing connection with "+socket.getInetAddress());
				socket.close();
				
			}catch(IOException e) {
				System.err.println("Server error with inbox: "+e);
			}
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
		}
	}

	String output;
	//This static checkQueue shares if 3rd queue is updated
	static Boolean checkQueue = false;
	//This static Task value is the final result
	static Task returnTask = new Task();
	//if anything is in 3rd queue this method is called
	
	//get notify when the task is finished processing
	@Override
	public void update(Observable o, Object task) {
		returnTask = ((Task)task);
		output = "Task identifier: "+returnTask.identifier+" value: "+returnTask.value+" is processed";
		System.out.println(output);
		checkQueue = true;
	}
	
	//static method that can share Task object
	public static Task toOutputSocket() {
		Task outputTask = new Task();
		outputTask = returnTask;
		checkQueue = true;
		return outputTask;
	}
	
	//inner class for an outbox thread
	public class Outbox implements Runnable{
		private Socket socket;
		private AddOneWorker addOne;
		
		//constructor
		public Outbox(Socket socket) {
			this.socket = socket;
			this.addOne = new AddOneWorker();
		}

		@Override
		public void run() {
			PrintWriter pw;
			Task task = new Task();
			boolean loop = true;
			//autoflush
			try {
				pw = new PrintWriter(socket.getOutputStream(), true);
				//let this output thread keep check boolean
				while(loop) {
					
					//if third queue changed, PrintWriter to client
					if(checkQueue) {
						task = toOutputSocket();
						pw.println(output = "Task identifier: "+task.identifier+" value: "+task.value+" is processed");
						checkQueue = false;
						loop = false;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				pw.close();
				System.out.println("Closing connection with "+socket.getInetAddress());
				socket.close();
			} catch (IOException e) {
				System.err.println("Server error with outbox: "+e);
			}
		}	
	}
}


