package server.serverdata;

import ocsf.server.ConnectionToClient;

public class UserData 
{
	private String username;
	private ConnectionToClient conn;
	private int wins;
	private int totalGames;
	
	public void newUser(String Username, ConnectionToClient conn) 
	{
		this.username = Username;
		this.conn = conn;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setPlayAgain(String username) 
	{
		this.username = username;
	}
	
	public String getPlayAgain() 
	{
		return this.username;
	}
	
	public ConnectionToClient getConn() 
	{
		return conn;
	}
	
	public void setConn(ConnectionToClient conn) 
	{
		this.conn = conn;
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
