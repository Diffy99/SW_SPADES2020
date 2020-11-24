package server;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import game_Manager.GameManager;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.serverdata.BoardGameData;
import server.serverdata.CreateAccountData;
import server.serverdata.LoginData;
import server.serverdata.PostGameData;
import server.serverdata.UserData;

public class GameServer extends AbstractServer {
	private static UserManager userManager;
	private static ArrayList<UserData> connectedClients;
	private static ArrayList<Long> waitingForGame;
	private static ArrayList<GameManager> activeGames;
	private static GameManager activegame;
	private static boolean player2present;

	private JLabel status;
	private JTextArea log;

	public GameServer() {
		super(8300);
		waitingForGame = new ArrayList<Long>();
		connectedClients = new ArrayList<UserData>();
		activeGames = new ArrayList<GameManager>();
		activegame = null;
		player2present = false;
	}

	public GameServer(int port) {
		super(port);
		waitingForGame = new ArrayList<Long>();
		connectedClients = new ArrayList<UserData>();
		activeGames = new ArrayList<GameManager>();
		activegame = null;
		player2present = false;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		log.append("Messgage from Client: " + arg1.getId() + "\n");
		try {
			// stuff for game manager
			if (arg0 instanceof BoardGameData) {
				// Send Data To Game Manager
			} else if (arg0 instanceof PostGameData) {
				// Send Data To GameManager
				// possible send to User manager to update database
			}

			// stuff for usermanager
			if (arg0 instanceof LoginData) {
				// Send Data To UserManager for login data
				userManager.VerifyLogin((LoginData) arg0, arg1);
			} else if (arg0 instanceof CreateAccountData) {
				// Send Data To UserManager for Creating and account
				userManager.VerifyCreateAccount((CreateAccountData) arg0, arg1);
			}

			if (arg0 instanceof String) {
				String temp = (String) arg0;
				if (temp.equals("Logout")) {
					// do something on logout
					System.out.println("Logout recieved for " + arg1.getId());
				} else if (temp.equals("Waiting for game")) {
					UserData temp1 = null;
					System.out.println(arg1.getId() + " Is waiting for a game");
					for (UserData connecteduser : connectedClients) {
						if (connecteduser.getConnectionID() == arg1.getId()) {
							temp1 = connecteduser;
						}
					}
					if (activegame == null) {
						GameManager game = new GameManager(temp1);
						activegame = game;
						arg1.sendToClient("Game Created");
						System.out.println("Game Created for" + arg1.getId());
					} else {
						arg1.sendToClient("Game is ready to join " + arg1.getId());
						player2present = true;
					}
				} else if (temp.equals("In Queue")) {
					System.out.println("Player in Queue");
					System.out.println(player2present);
					if (player2present) {
						arg1.sendToClient("Game is ready to join " + arg1.getId());
					}
					else {
						arg1.sendToClient("Game not found yet");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private void addToWait(ConnectionToClient arg1) { // TODO Auto-generated
	 * method stub UserData temp1 = null; UserData temp2 = null; if
	 * (waitingForGame.isEmpty()) { System.out.println("User added to wait list");
	 * waitingForGame.add(arg1.getId()); } else {
	 * System.out.println("Creating Game"); for (UserData clients :
	 * connectedClients) { if (clients.getConnectionID() == arg1.getId()) { temp1 =
	 * clients; } else if (clients.getConnectionID() == waitingForGame.get(0)) {
	 * temp2 = clients; } } GameManager tempgame = new GameManager(temp1, temp2);
	 * activeGames.add(tempgame); waitingForGame.remove(0); try {
	 * arg1.sendToClient("Game Ready"); System.out.println("Game Ready Sent to " +
	 * arg1.getId()); } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */
	protected void listeningException(Throwable exception) {
		// Display info about the exception
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
		log.append("Client connected and given connection ID: " + client.getId() + "\n");

	}

	public void addConnection(UserData conn) {
		if (connectedClients.isEmpty()) {
			connectedClients.add(conn);
			System.out.println("Connected User added " + conn.getUsername());
			log.append("Connected User added " + conn.getUsername() + "\n");
		} else if (!connectedClients.contains(conn)) {
			connectedClients.add(conn);
			System.out.println("Connected User added " + conn.getUsername());
			log.append("Connected User added " + conn.getUsername() + "\n");
		} else {
			connectedClients.remove(conn);
			connectedClients.add(conn);
			System.out.println("Connected User removed then added " + conn.getUsername());
			log.append("Connected User removed then added " + conn.getUsername() + "\n");
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
