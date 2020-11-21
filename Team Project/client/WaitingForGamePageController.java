package client;

import java.awt.CardLayout;

import javax.swing.JPanel;

import java.awt.event.*;

public class WaitingForGamePageController implements ActionListener { 
	
	private JPanel container;
	private GameClient gameClient;
	
	public WaitingForGamePageController(JPanel container,GameClient gameClient) {
		this.container = container;
	    this.gameClient = gameClient;
		
		
	}
	public void connectSuccess() {
		
		GameBoardPage gameboard = (GameBoardPage)container.getComponent(5);
	    
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "6");
		
	}
	
	 public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();

	    // The Cancel button takes the user back to the login panel.
	    if (command == "Cancel")
	    {
	      gameClient.sendToServer("Search Canceled");
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "3");
	    }
	   
	  }
	
	

}
