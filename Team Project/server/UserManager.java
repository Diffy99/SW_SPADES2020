package server;


import java.io.IOException;

import ocsf.server.ConnectionToClient;

public class UserManager {

	private GameServer gameServer;
	private Database db;

	public UserManager(GameServer gameServer) {
		this.gameServer = gameServer;
		db = new Database();
	}

	public void VerifyLogin(LoginData loginData, ConnectionToClient arg1) throws IOException 
	{
		//Search Database with Login Data query on username
		if(db.verifyAccount(loginData.getUsername(), loginData.getPassword()) == false) 
		{
		 	arg1.sendToClient("Incorrect Username/Password");
	 	}
		else 
	    {
			arg1.sendToClient("Login Successful");
	    }
	 	
	}

	public void VerifyCreateAccount(CreateAccountData createAccountData, ConnectionToClient arg1) throws IOException 
	{
		
		//Search Database with Login Data query on username
		if(db.createNewAccount(createAccountData.getUsername(), createAccountData.getPassword()) == false) 
		{
			arg1.sendToClient("Username Already Taken");
		}
	    else 
	    {
	   	 	arg1.sendToClient("Account Created");
	    }
	
		}

	public void UpdateTotalGames(ConnectionToClient arg1) {
		//increase total number of games for recieved user
	}
	public void UpdateWins(ConnectionToClient arg1) {
		//increase win number of games for recieved user
	}
}
