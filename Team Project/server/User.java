package server;

public class User 
{
	private String username;
	private int connectionID;
	private int wins;
	private int totalGames;
	
	public void setPlayAgain(String username) 
	{
		this.username = username;
	}
	
	public String getPlayAgain() 
	{
		return this.username;
	}
	
	public void setConnectionID(int connectionID) 
	{
		this.connectionID = connectionID;
	}
	
	public int getConnectionID() 
	{
		return this.connectionID;
	}
	
	public void setWins(int wins) 
	{
		this.wins = wins;
	}
	
	public int getWins() 
	{
		return this.wins;
	}
	
	public void setTotalGames(int totalGames) 
	{
		this.totalGames = totalGames;
	}
	
	public int getTotalGames() 
	{
		return this.totalGames;
	}
}
