package server.serverdata;

import ocsf.server.ConnectionToClient;

public class UserData {

	private String Username;
	private ConnectionToClient conn;
	
	public void newUser(String Username,ConnectionToClient conn) {
		this.Username = Username;
		this.conn = conn;
	}
	
	public ConnectionToClient getConn() {
		return conn;
	}
	public void setConn(ConnectionToClient conn) {
		this.conn = conn;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
}
