/*
  Karime Saad
  UT EID: ks38728
*/

package bonus_assignment;

class BlackAndWhitePegs
{
	private int totalBlack;
	private int totalWhite;
	
	public BlackAndWhitePegs()
	{
		totalBlack = 0;
		totalWhite = 0;
	}
	
	public BlackAndWhitePegs(int black, int white)
	{
		totalBlack = black;
		totalWhite = white;
	}
	
	public String printStringArray(int lengt)
	{
		String[] almost = new String[lengt];
		if(totalBlack == 0 && totalWhite == 0)
		{
			return "No pegs";
		}
		int index = 0;
		//append black
		if(totalBlack > 0)
		{
			for(int i = 1; i <= totalBlack; i++)
			{
				almost[index] = "Black ";
				index++;
			}
		}
		//append white
		if(totalWhite > 0)
		{
			for(int i = 1; i <=totalWhite; i++)
			{
				almost[index] = "White ";
				index++;
			}
		}
		//Make the string array into a string
		String result = "";
		for(int l = 0; l < index; l++)
		{
			result += almost[l];
		}
		return result;
	}
}