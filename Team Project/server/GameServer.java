package server;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.serverdata.BoredGameData;
import server.serverdata.CreateAccountData;
import server.serverdata.LoginData;
import server.serverdata.PostGameData;
import server.serverdata.UserData;

public class GameServer extends AbstractServer {
	private static UserManager userManager;
	private static ArrayList<UserData> connectedUsers;
	private static ArrayList<UserData> waitingForGame;
	
	private JLabel status;
	private JTextArea log;
	
	  public GameServer() {
		  super(8300);
		  connectedUsers = new ArrayList<UserData>();
		  waitingForGame = new ArrayList<UserData>();
	}
	  public GameServer(int port) {
		  super(port);	
	}

	  public void setUserManager(UserManager userManager) {
		  this.userManager = userManager;
	  }
	
	 
	  
	  
	  
	  @Override
	  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	  {
		  log.append("Messgage from Client: " + arg1.getId()+"\n");
		  try {
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
				userManager.VerifyLogin((LoginData)arg0, arg1);
				CheckConnectedUsers();
		  }
		  else if(arg0 instanceof CreateAccountData) {
			//Send Data To UserManager for Creating and account
			  userManager.VerifyCreateAccount((CreateAccountData)arg0, arg1);
		  }
			  
		  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			log.append("Server Started\n");
			status.setText("Server Started");
			status.setForeground(Color.GREEN);
		}
		
	  
		public void serverStopped() {
			System.out.println("Server Stopped");
		}
		
		public void serverClosed() {
			System.out.println("Server closed");
		}
		
		public void clientConnected(ConnectionToClient client) {
			System.out.println("Client connected and given connection ID: " + client.getId());
			log.append("Client connected and given connection ID: " + client.getId()+"\n");

		}



		public static ArrayList<UserData> getConnectedUsers() {
			return connectedUsers;
		}
		public static void addConnectedUsers(UserData connectedUser) {
			connectedUsers.add(connectedUser);
		}
		public static void CheckConnectedUsers() {
			for (Iterator iterator = connectedUsers.iterator(); iterator.hasNext();) {
				UserData userData = (UserData) iterator.next();
				System.out.println("Client " + userData.getUsername() + "Is Connected: " + !userData.getConn().isAlive());
				if(!userData.getConn().isAlive()) {
					connectedUsers.remove(userData);
				}
				
			} 
		}
		public void setStatus(JLabel status) {
			// TODO Auto-generated method stub
			this.status = status;
			
		}
		public void setLog(JTextArea log) {
			// TODO Auto-generated method stub
			this.log = log;
			
		}
}
