package server.serverdata;

import java.io.Serializable;
import java.util.ArrayList;

public class BoardGameData implements Serializable
{
	ArrayList<String> currentHand = new ArrayList<String>();
	private String currentMove;
	private int currentBet;
	private int score;

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

	public void setCurrentMove(String currentMove) 
	{
		this.currentMove = currentMove;
	}
	
	public String getCurrentMove() 
	{
		return currentMove;
	}

	public void setCurrentHand(ArrayList<String> currentHand) 
	{
		this.currentHand = currentHand;
	}
	
	public ArrayList<String> getCurrentHand()
	{
		return currentHand;
	}
	
}
