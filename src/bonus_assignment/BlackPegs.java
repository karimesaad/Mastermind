/*
  Karime Saad 
  UT EID: ks38728
  
  Eric Cruz
  UT EID: ec29992
  
*/

package bonus_assignment;

class BlackPegs
{
	private int black;
	
	public BlackPegs()
	{
		black = 0;
	}
	
	public int correctBlack(char[] secret, char[] user)
	{
		for(int i=0; i < secret.length; i++)
		{
			if(secret[i] == user[i])
			{
				black++;
			}
		}
		return black;
	}
	
	public int getBlack()
	{
		return black;
	}
}