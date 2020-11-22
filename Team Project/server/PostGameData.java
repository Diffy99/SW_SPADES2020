package server;

import java.io.Serializable;

public class PostGameData implements Serializable
{
	private boolean playAgain;
	
	public PostGameData() 
	{
		playAgain = false;
	}
	
	public PostGameData(boolean playAgain) 
	{
		this.playAgain = playAgain;
	}
	
	public void setPlayAgain(boolean playAgain) 
	{
		this.playAgain = playAgain;
	}
	
	public boolean getPlayAgain() 
	{
		return this.playAgain;
	}
}
