package server.serverdata;

import java.io.Serializable;

import ocsf.server.ConnectionToClient;

public class UserData implements Serializable
{
	private String username;
	private int wins;
	private int totalGames;
	private String Purpose;
	private Long connectionID;
	
	public UserData(String Username, long id) {
		// TODO Auto-generated constructor stub
		this.username = Username;
		this.connectionID = id;
	}

	public UserData() {
		// TODO Auto-generated constructor stub
		username = "";
		wins = 0;
		totalGames = 0;
		Purpose = "";
		connectionID = null;
	}

	public void newUser(String Username, long ID) 
	{
		this.username = Username;
		this.connectionID = ID;
		
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

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public Long getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(Long connectionID) {
		this.connectionID = connectionID;
	}
}
