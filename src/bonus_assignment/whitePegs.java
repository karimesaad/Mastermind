/*
  Karime Saad 
  UT EID: ks38728
  
  Eric Cruz
  UT EID: ec29992
  
*/
package bonus_assignment;

class WhitePegs
{
	private int white;
	
	//default constructor
	public WhitePegs()
	{
		white = 0;
	}
	
	//method to determine number of correctly placed pegs
	public int correctWhite(char[] secret, char[] user)
	{
		//create temp arrays
		char[] tempS = new char[secret.length];
		char[] tempU = new char[user.length];
		System.arraycopy(secret, 0, tempS, 0, secret.length);
		System.arraycopy(user, 0, tempU, 0, user.length);
		//check if it is not a black peg
		
		for(int i=0; i < tempS.length; i++)
		{
			if(tempS[i] == tempU[i])
			{
				
				tempU[i] = '8';
				tempS[i] = '4';
			}
		}
		
		for(int i=0; i < tempS.length; i++)
		{
			for(int j=0; j < tempU.length; j++)
			{				
				if(tempS[i] == tempU[j])
				{
					white++;
					tempS[i] = '3';
					tempU[j] = '2';
				}
			}	
		}
		return white;
	}
	
	public int getWhite()
	{
		return white;
	}
}