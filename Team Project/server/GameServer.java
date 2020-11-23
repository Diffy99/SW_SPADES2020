package server;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.serverdata.BoardGameData;
import server.serverdata.CreateAccountData;
import server.serverdata.LoginData;
import server.serverdata.PostGameData;
import server.serverdata.UserData;

public class GameServer extends AbstractServer {
	private static UserManager userManager;
	private static ArrayList<ConnectionToClient> connectedClients;
	private static ArrayList<UserData> waitingForGame;
	
	private JLabel status;
	private JTextArea log;
	
	  public GameServer() {
		  super(8300);
		  waitingForGame = new ArrayList<UserData>();
		  connectedClients = new ArrayList<ConnectionToClient>();
	}
	  public GameServer(int port) {
		  super(port);	
		  waitingForGame = new ArrayList<UserData>();
		  connectedClients = new ArrayList<ConnectionToClient>();
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
		  if(arg0 instanceof BoardGameData) {
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
				arg1.sendToClient(new UserData("",arg1.getId()));
		  }
		  else if(arg0 instanceof CreateAccountData) {
			//Send Data To UserManager for Creating and account
			  userManager.VerifyCreateAccount((CreateAccountData)arg0, arg1);
		  }
		  
		  
		  if(arg0 instanceof UserData) {
			  UserData temp = (UserData)arg0;
			  if(temp.getPurpose().equals("Logout")) {
				  //do something on logout
				  System.out.println("Logout recieved for " + temp.getUsername());
			  }
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

		public void addConnection(ConnectionToClient conn) {
			if(connectedClients.isEmpty()) {
				connectedClients.add(conn);	
				System.out.println("Connected User added " + conn.getId());
				log.append("Connected User added "  + conn.getId()+"\n");
			}
			else if(!connectedClients.contains(conn)) {
				connectedClients.add(conn);	
				System.out.println("Connected User added " + conn.getId());
				log.append("Connected User added "  + conn.getId()+"\n");
			}
			else {
				connectedClients.remove(conn);
				connectedClients.add(conn);
				System.out.println("Connected User removed then added " + conn.getId());
				log.append("Connected User removed then added "  + conn.getId()+"\n");
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
