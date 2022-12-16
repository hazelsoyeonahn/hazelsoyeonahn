package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WDPlayer implements Comparable<WDPlayer>{
	
		private String playerName;
		private int nPieces;
		private int nPrevent;
		
		public WDPlayer(String playerName, int nPieces, int nPrevent) {
			super();
			this.playerName = playerName;
			this.nPieces = nPieces;
			this.nPrevent = nPrevent;
		}
		
		public String getPlayerName() {
			return playerName;
		}
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
		public int getnPieces() {
			return nPieces;
		}
		public void setnPieces(int nPieces) {
			this.nPieces = nPieces;
		}
		public int getnPrevent() {
			return nPrevent;
		}
		public void setnPrevent(int nPrevent) {
			this.nPrevent = nPrevent;
		}
	
		//returning double value 
		public Double rank() {
			
			return (double)(1-1/(nPieces*nPrevent));
		}
		
		//compareTo method, when it returns 0 : both are equal. 
		//when it returns 1 current object is greater
		public int compareTo(WDPlayer o) {
			return (int)(this.rank()-o.rank());
		}
		@Override
		public String toString() {
			return "WDPlayer [playerName=" + playerName + ", nPieces=" + nPieces + ", nPrevent=" + nPrevent + ", rankt=" +this.rank()+"]";
		}
		
		public static void main(String[] args) {
			ArrayList<WDPlayer> wList = inputPlayer();
			
			for(WDPlayer wdPlayer : wList) {
				System.out.println(wdPlayer);
			}
		}
		
		//method to return sorted arraylist
		
		private static ArrayList<WDPlayer> inputPlayer(){
			ArrayList<WDPlayer> aList = new ArrayList<>();
			Scanner scanner = new Scanner(System.in);
				
			while(true) {
				System.out.println("Enter name, number of information pieces and number of crime prevented. Type stop if you want to exit");
					
				String playerName = scanner.next();
				if(playerName.equalsIgnoreCase("stop")) {
					System.out.println("Now, returning sorted arrayList");
					break;
				}
					
				int nPieces = scanner.nextInt();
				int nPrevent = scanner.nextInt();
				
				aList.add(new WDPlayer(playerName, nPieces, nPrevent));
			}
			Collections.sort(aList);
			return aList;
		}
	
	}


