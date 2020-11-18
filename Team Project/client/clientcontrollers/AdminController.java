package client.clientcontrollers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import client.GameClient;

public class AdminController {

	  private JPanel container;
	  private GameClient gameClient;
	
	
	public AdminController(JPanel container, GameClient gameClient) {
		this.container = container;
		this.gameClient = gameClient;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    if(command == "Main Menu")
	    {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	        cardLayout.show(container, "3");
	    }
	  }

}
