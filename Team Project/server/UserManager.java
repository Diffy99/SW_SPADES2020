package server;


import java.io.IOException;

import ocsf.server.ConnectionToClient;
import server.serverdata.CreateAccountData;
import server.serverdata.LoginData;
import server.serverdata.UserData;

public class UserManager {

	private GameServer gameServer;
	private Database db;

	public UserManager(GameServer gameServer) {
		this.gameServer = gameServer;
	}
	
	public void setDatabase(Database db) {
		this.db = db;
	}

	public void VerifyLogin(LoginData loginData, ConnectionToClient arg1) throws IOException 
	{
		//Search Database with Login Data query on username
		if(!db.verifyAccount(loginData.getUsername(), loginData.getPassword())) 
		{
		 	arg1.sendToClient("Incorrect Username/Password");
	 	}
		else 
	    {
			arg1.sendToClient("Login Successful");
			// create a user object with the data from the database along with the recieved connection id
			UserData tempuser = new UserData();
			tempuser.newUser(loginData.getUsername(), arg1);
			GameServer.addConnectedUsers(tempuser);
			
	    }
	 	
	}

	public void VerifyCreateAccount(CreateAccountData createAccountData, ConnectionToClient arg1) throws IOException 
	{
		
		//Search Database with Login Data query on username
		if(!db.createNewAccount(createAccountData.getUsername(), createAccountData.getPassword())) 
		{
			arg1.sendToClient("Username Already Taken");
		}
	    else 
	    {
	   	 	arg1.sendToClient("Account Created");
	    }
	
		}

	public void UpdateTotalGames(ConnectionToClient arg1) {
		//increase total number of games for recieved user in database
	}
	public void UpdateWins(ConnectionToClient arg1) {
		//increase win number of games for recieved user in database
	}
}
