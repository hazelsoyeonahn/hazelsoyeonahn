package example;
/*
 * This client class connects to ProcessServer with two different port.
 * One port that passes a task and another port that receives a processed task.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Client{
	public static final int IN_PORT = 3433;
	public static final int OUT_PORT = 4343;
	public static final String HOST_NAME = "localhost";
	public ProcessServer proServer = new ProcessServer();
	
	public Client(){
	}
	
	//start client
	public void startClient() {
		Socket InSocket = null;
		Socket OutSocket = null;
		Scanner keyboardInput = new Scanner(System.in);
		
		//connect the socket with IN_PORT
		try {
			InSocket = new Socket(HOST_NAME, IN_PORT);
		}catch(IOException e) {
			System.err.println("Client could not make connection with IN_PORT: "+e);
			System.exit(-1);
		}
		
		//connect the socket with OUT_PORT
		try {
			OutSocket = new Socket(HOST_NAME, OUT_PORT);
		}catch(IOException e) {
			System.err.println("Client could not make connection with OUT_PORT: "+e);
		}
		
		PrintWriter pw; //output stream to server
		BufferedReader br; //input stream from server
		BufferedReader br2; //input stream from server with port2
		
		try {
			//get an autoflush output stream for the socket
			pw = new PrintWriter(InSocket.getOutputStream(), true);
			//get an buffered input stream for the socket
			br = new BufferedReader(new InputStreamReader(InSocket.getInputStream()));
			br2 = new BufferedReader(new InputStreamReader(OutSocket.getInputStream()));
			
			//get user input and output
			boolean finished = false;
			do {
				String serverResponse = br.readLine();
				System.out.println(serverResponse);
				if(serverResponse.toLowerCase().indexOf("quit")==0)
					finished = true;
				else {
					pw.println(keyboardInput.nextLine());
					
					
					Task task = new Task(); //new task is ready
					proServer.getTask(task); //pass the task to server
					serverResponse = br2.readLine();
					System.out.println(serverResponse); //recieve the final task output
					System.out.println("Now terminating the program");
					finished = true;
				}
			}while(!finished);
			//close all connection
			pw.close();
			br.close();
			InSocket.close();
			OutSocket.close();
		}catch(IOException e) {
			System.err.println("Client error with game: "+ e);
		}
	}

	//main method to start client
	public static void main(String args[]) {
		Client client1 = new Client();  //later make client throw multiple tasks with threads
		client1.startClient();
	}
}
