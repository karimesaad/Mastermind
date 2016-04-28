/*
  Karime Saad
  UT EID: ks38728
*/

package bonus_assignment;

import java.util.Scanner;

//Create game class for testing purposes
class Game
{
	private BlackPegs numB; //gives black pegs
	private WhitePegs numW; //gives white pegs
	private BlackAndWhitePegs pbandw; //the string which says how many black and white pegs there are
	private char[] rand;
	char[] colorInitials = {'B', 'G', 'O', 'P', 'R', 'Y'};
	private String[] colorNames = {"Black", "Green", "Orange", "Purple", "Yellow"};
	private char[] user;
	private String userS;
	
//	public Game(){
//	
//	}
//	
	public void buildGame(){
		
	//RandString
	//	r = new RandString(base.getNumPegs(), base.getColorInitialsArray());

		rand = new char[4];
		
		for(int i = 0; i < 4; i++)
		{
			int randomIndex = (int)(Math.random()*4);
			rand[i] = colorInitials[randomIndex];
		}
		
		numB = new BlackPegs();
		numW = new WhitePegs();
		pbandw = new BlackAndWhitePegs();
		//**user = new inputString(4);
	}
	
	public void readString()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter. You can also type 'history' to see previous guesses and results.");
		System.out.print("Enter guess: ");
		String s = sc.next();
		userS = s;
		if (s.equals("history")){
			Mastermind.printBoard(Mastermind.board);
		}
		user = new char[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			user[i] = s.charAt(i);
		}
	}
	
	public boolean validCase (){
		if(user.length != 4)
		{
			return false;
		}
		for(int i = 0; i < 4; i++)
		{
			if(user[i] < 'A' || user [i] > 'Z')
			{
				return false;
			}
		}	
		
		int t = 0;
				
		for(int i = 0; i < 4; i++)
		{
			if(user[i] == 'B'|| user[i] == 'G'|| user[i] == 'O' || user[i] == 'P' || user[i] =='R' || user[i] == 'Y')
			{
				t++;
				
			}
		}
		return (t == 4);
	}
	
	//Access what the user inputed
	public char[] getUserArray(){
		return getInputArray();
	}
	public String getString(){
		return userS;
	}
	
	//Make a random array with the colors (already in char[] a)
	public char[] getSecretCode(){
		return rand;
	}
	
	public String getSecretString(){
		String result = "";
		for(int i = 0; i < 4; i++)
		{
			result += rand[i];
		}
		return result;
	}
	
	//returns what the user inputed
	public char[] getInputArray(){
		return user;
	}
	
	//get the number of black and white pegs
	public int getNumBlack(){
		numB = new BlackPegs();
		return numB.correctBlack(rand, getInputArray());
	}
	public int getNumWhite(){
		numW = new WhitePegs();
		return numW.correctWhite(rand, getInputArray());
	}
	
	//Return the string with the correct amount of "Black" "White" or "No Pegs"
	public String printBlackWhite(int b, int w){
		pbandw = new BlackAndWhitePegs(b, w);
		return pbandw.printStringArray(4);
	}
	
	public String colors(){
		String result = "";
		for(int i = 0; i < 6; i++)
		{
			if(i == 5)
			{
				result += colorNames[i];
			}
			else
			{
				result += colorNames[i] + " ";
			}
		}
		return result;
	}

}