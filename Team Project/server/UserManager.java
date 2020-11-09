package server;


import ocsf.server.ConnectionToClient;

public class UserManager {

	private GameServer gameServer;
	private DatabaseFile db;

	public UserManager(GameServer gameServer) {
		this.gameServer = gameServer;
		db = new DatabaseFile();
	}

	public void VerifyLogin(LoginData loginData, ConnectionToClient arg1) {
	 //Search Database with Login Data query on username
		if(db.query(loginData.getUsername()) == null) {
		 	arg1.sendToClient("Incorrect Username/Password");
	 	}
	 	If(loginData.getPassword() == db)}

		{
			.sendToClient("Login Successful");
		//update db to know what most recent connection id this username is using.
		}
	}

	public void VerifyCreateAccount(CreateAccountData loginData, ConnectionToClient arg1)
	//Search Database with Login Data query on username
	 if(db.query(loginData.getUsername()) != null) {
		 arg1.sendToClient("Username Already Taken");
	 }
    else
	 arg1.sendToClient("Account Created");
	}

	public void UpdateTotalGames(ConnectionToClient arg1) {
		//increase total number of games for recieved user
	}
	public void UpdateWins(ConnectionToClient arg1) {
		//increase win number of games for recieved user
	}
}
