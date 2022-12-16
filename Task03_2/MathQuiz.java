package Task03_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MathQuiz {
	private Random random;
	
	public MathQuiz() {
		this.random = new Random();
	}

	public int getNumber() {
		int number = random.nextInt(100);
		return number;
	}
	
	public int getOperator() {
		int operator = random.nextInt(3);
		return operator;
	}
	
	public static void main(String args[]) {
		//declare random number and number for choosing operator.
		MathQuiz quiz = new MathQuiz(); 
		int answer = 0;
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		int score = 0; //the score always start from 0.
		
		System.out.println("Welcome to Math Quiz. Please input an answer.");
		System.out.println("type x when you want to quit");
		System.out.println("====================\n");
		
	
		
		String userInput = null;
		while(loop) {
			int number1 = quiz.getNumber();
			int number2 = quiz.getNumber();
			int operator = quiz.getOperator();
			
			//operator has a range of 0 to 3. 
			if(operator == 0) {
				System.out.println(number1+" + "+number2+"=");	
				answer = number1+number2;
			}
			else if(operator == 1) {
				System.out.println(number1+" - "+number2+"=");
				answer = number1-number2;
			}
			else if(operator == 2) {
				System.out.println(number1+" * "+number2+"=");
				answer = number1*number2;
			}
			else if(operator == 3) {
				System.out.println(number1+" / "+number2+"=");
				answer = number1/number2;
			}
			
				userInput = scan.next();
				if(userInput.equals("x")) {
					break;
				}
				try {
					//if integer is int and answer is correct
					if(Integer.parseInt(userInput) == answer) {
						System.out.println("Correct! You gained 10 points");
						score+=10;
					}
					
					//if integer is int but answer is incorrect
					else if(Integer.parseInt(userInput) != answer) {
						System.out.println("Wrong! You lost 10 points");
						score-=10;
					}
				
					//int isInt = Integer.parseInt(userInput);
				}catch(NumberFormatException e) {
					System.out.println("You must enter integer. Try again.");
				}
				scan.nextLine();
		}
		
		System.out.println("The game is over. Your total score is "+score);
	
	}
}
