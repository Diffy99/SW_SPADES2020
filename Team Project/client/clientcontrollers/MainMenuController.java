package client.clientcontrollers;

import java.awt.*;
import javax.swing.*;

import client.GameClient;

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
    LoginData data = new LoginData(loginPage.getUsername(), loginPage.getPassword());
    // The logout button takes the user back to the login panel.
    if (command == "Logout")
    {
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "1");
    }

    // The play button takes user to waiting for game page
    else if (command == "Play")
    {
    	 CardLayout cardLayout = (CardLayout)container.getLayout();
         cardLayout.show(container, "5");
    }
    
    //The admin button takes the user to the admin page
    else if (command == "Admin Page" && data.getUsername().equals("Username") && data.getPassword().equals("password"))
    {
    	
    	CardLayout cardLayout = (CardLayout)container.getLayout();
        cardLayout.show(container, "4");
    }
  }


}
