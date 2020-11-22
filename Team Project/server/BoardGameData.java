package server;

import java.io.Serializable;

public class BoardGameData implements Serializable
{
	//currentHand
	//currentMove 
	private int currentBet;
	private int score;
	
	public BoardGameData()
	{
		currentBet = 0;
		score = 0;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public void setCurrentBet(int currentBet) 
	{
		this.currentBet = currentBet;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public int getCurrentBet() 
	{
		return currentBet;
	}


}
