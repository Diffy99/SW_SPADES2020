package server;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer {
	
	
	
	
	
	
	  public GameServer() {
		  super(8300);
	}
	  public GameServer(int port) {
		  super(port);	
	}

	
	 
	  
	  
	  
	  @Override
	  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	  {
		  //stuff for game manager
		  if(arg0 instanceof BoredGameData) {
				//Send Data To Game Manager
			  }
		  else if(arg0 instanceof PostGameData) {
				//Send Data To GameManager 
			    //possible send to User manager to update database
			  }
		  
		  
		  //stuff for usermanager
		  if(arg0 instanceof LoginData) {
			  //Send Data To UserManager for login data
		  }
		  else if(arg0 instanceof CreateAccountData) {
			//Send Data To UserManager for Creating and account
		  }
			  
	  

	  }
	  
	  protected void listeningException(Throwable exception) 
	  {
	    //Display info about the exception
	    System.out.println("Listening Exception:" + exception);
	    exception.printStackTrace();
	    System.out.println(exception.getMessage());
	    
	  }
	  
	  	public void serverStarted() {
			System.out.println("Server Started");
		}
		
	  
		public void serverStopped() {
			System.out.println("Server Stopped");
		}
		
		public void serverClosed() {
			System.out.println("Server closed");
		}
		
		public void clientConnected(ConnectionToClient client) {
			System.out.println("Client connected and given connection ID: " + client.getId());

		}
}
