package client.clientcontrollers;

import java.awt.*;
import java.lang.*;
import javax.swing.*;

import client.GameClient;
import client.clientpages.LoginPage;
import server.serverdata.UserData;

import java.awt.event.*;
import java.io.IOException;

public class MainMenuController implements ActionListener
{
  // Private data fields for the container and game client.
  private JPanel container;
  private GameClient gameClient;
 

  
  // Constructor for the main menu controller.
  public MainMenuController(JPanel container,GameClient gameClient)
  {
    this.container = container;
    this.gameClient = gameClient;
    

  }
  
  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();
  //  LoginData data = new LoginData(loginPage.getUsername(), loginPage.getPassword());
    // The logout button takes the user back to the login panel.
    if (command == "Logout")
    {
    	
      try {
		gameClient.sendToServer("Logging out");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.exit(0);
      
    }

    // The play button takes user to waiting for game page
    else if (command == "Play")
    {
    	 CardLayout cardLayout = (CardLayout)container.getLayout();
         cardLayout.show(container, "5");
         
         try {
        	Thread.sleep(250);
			gameClient.sendToServer("Waiting for game");
			gameClient.startqueue();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //The admin button takes the user to the admin page
    else if (command == "Admin Page")
    {
    	
    	CardLayout cardLayout = (CardLayout)container.getLayout();
        cardLayout.show(container, "4");
    }
  }

  
  

}
