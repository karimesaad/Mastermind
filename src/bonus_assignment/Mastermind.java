/*
  Karime Saad
  UT EID: ks38728
*/

package bonus_assignment;

import java.io.*;
import java.util.*;
public class Mastermind
{
	static int guesses = 12;
	static String [] board = new String[guesses];
	
	//Method with the instructions
	public static void welcome(){
		System.out.println("Welcome to Mastermind.");
		System.out.println();
		System.out.println("This is a text version of the classic board game Mastermind.");
		System.out.println("The computer will think of a secret code.");
		System.out.println("The code consists of 4 colored pegs.");
		System.out.println("The pegs may be one of the following colors: Blue, Green, Orange, Purple, Red and Yellow.");
		System.out.println("A color may appear more than once in the code.");
		System.out.println();
		System.out.println("You try to guess what colored pegs are in the code and what order they are in");
		System.out.println("After making a guess the result will be displayed.");
		System.out.println("A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.");
		System.out.println("For each peg in the guess that is the correct color, but is out of position, you get a white peg.");
		System.out.println();
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.");
		System.out.println("When entering guesses you only need to enter the first character of the color as a capital letter.");
		System.out.println("You have " + guesses + " to get the answer or you lose the game.");
		System.out.println();
	}
	static void printBoard(String[] board){
		System.out.println("");
		for(int i = 0; i < 12; i++){
			if(!board[i].equals("....")){
			System.out.println(board[i]);
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws IOException{
		boolean on = true;
		String repeat;
		Game game = new Game();
		//print the instructions
		welcome();
		System.out.println();

		while(on){

			//build a new game
			game.buildGame();
			//Start the game
			//fill the array with 4 dots
			for(int i = 0; i < guesses; i++)
			{
				board[i] = "....";
			}
			//keep track of where you are keeping the guesses
			int index = 0;
			System.out.println("");
			System.out.println("Mastermind is generating a new secret code...");
			System.out.println();
			while(guesses > 0){
				if(guesses <= 12)
				{
					if(guesses==12){
						System.out.println("You have " + guesses + " guesses left");
					} else { 
						System.out.println("Incorrect! Try again. You have " + guesses + " guesses left");
					}
					System.out.println();
				}
				System.out.println();
				game.readString();
				boolean valid = game.validCase();
				while(!valid){
					game.readString();
					valid = game.validCase();
				}
				int black = game.getNumBlack();
				int white = game.getNumWhite();
				String bw = game.printBlackWhite(black, white);
				board[index] = "Your guess: " + game.getString() + " -----"+ " Result: " + bw;
				System.out.println("");
				System.out.println(board[index]);
				index++;
				System.out.println();
				guesses--;
				if(black == 4){
					System.out.println("Congrats! You solved the puzzle. You win!");
					guesses = -1;
				}	
			}

			if(guesses == 0)
			{
				System.out.println("You have no more guesses left.");
				System.out.println("The secret code was: " + game.getSecretString());
				System.out.println();
				System.out.println("------ GAME OVER -----");
				System.out.println();
				System.out.println();
			}
	
			Scanner sc = new Scanner(System.in);
			System.out.println("Are you ready for another game? (Y/N)");
			repeat = sc.next();
			//Repeat if the user inputs "reset"
			
			while(!repeat.equals("Y") && !repeat.equals("N")){
				System.out.println("Type 'Y' if you would like to play again, and type 'N' if you would like to exit the game.");
				repeat = sc.next();
			}

			if(repeat.equals("Y")){
				on = (repeat.equals("Y"));
				guesses = 12;
			} else {
				System.out.println("Thanks for playing!");
				System.exit(1);
			}
			
		}
	}

}