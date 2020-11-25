package client;

import client.clientcontrollers.AdminController;
import client.clientcontrollers.CreateAccountController;
import client.clientcontrollers.GameBoardController;
import client.clientcontrollers.InitialPageController;
import client.clientcontrollers.LoginController;
import client.clientcontrollers.MainMenuController;
import client.clientcontrollers.PostGameController;
import client.clientcontrollers.WaitingForGamePageController;
import ocsf.client.AbstractClient;
import server.serverdata.UserData;

public class GameClient extends AbstractClient
{
	LoginController lc;
    CreateAccountController cac; 
    MainMenuController mmc;
    AdminController apc;
    WaitingForGamePageController wfgpc;
    GameBoardController gbc;
    PostGameController pgc;
    InitialPageController ipc;
    UserData userData;
    
    
   public void setPanels(InitialPageController ipc, LoginController lc,CreateAccountController cac, MainMenuController mmc,AdminController apc, WaitingForGamePageController wfgpc,GameBoardController gbc, PostGameController pgc) {
	   this.lc = lc;
	   this.cac = cac;
	   this.mmc = mmc;
	   this.apc = apc;
	   this.wfgpc = wfgpc;
	   this.gbc = gbc;
	   this.pgc = pgc;
	   this.ipc = ipc;
   }
  
  public GameClient()
  {
    super("71.129.97.242",8300);
  }

  public void handleMessageFromServer(Object arg0)
  {
	 
    if(arg0 instanceof String) {
    	String message = (String)arg0;
    	if(message.equals("Incorrect Username/Password")) {
    		System.out.println("Login fail recieved");
    		lc.loginfail();
    		
    	}
    	else if(message.equals("Login Successful")) {
    		System.out.println("Login successful");
    		lc.loginSuccess();
    	}
    	else if(message.equals("Account Created")) {
    		cac.createaccountsucess();
    	}
    	else if(message.equals("Username Already Taken")) {
    		cac.createaccountfailure();
    	}
    	else if(message.equals("Admin Data")) {
    		apc.setAdminData();
    	}
    	else if (message.equals("Game is ready to join")){
    		System.out.println(message);
    		gbc.display();
    	}
    	else if(message.equals("Game Created")) {
    		System.out.println(message);
    		wfgpc.display();
    		gbc.setMakefirstmove(true);
    		
    	}
    	else if(message.equals("Game not found yet")) {
    		System.out.println(message);
    	}
    }
    if (arg0 instanceof UserData) {
    	System.out.println("UserData Set");
    	userData = (UserData)arg0;
    }

  }
 
  
  public void connectionException (Throwable exception) 
  {
    
  }
  public void connectionEstablished()
  {
	  
  }
	  
	 public UserData getUser() {
		 return userData;
	 }
	  
  

}
