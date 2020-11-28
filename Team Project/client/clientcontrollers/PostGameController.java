package client.clientcontrollers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import client.GameClient;

public class PostGameController  implements ActionListener {
	
	  private JPanel container;
	  private GameClient gameClient;
	  
	  public PostGameController(JPanel container, GameClient gameClient) {
		  this.container = container;
		  this.gameClient = gameClient;
	  }
	  
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    
	    if(command == "Play Again")
	    {
	    	try {
				gameClient.sendToServer("Waiting for game");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else if(command == "Quit")
	    {
	    	  CardLayout cardLayout = (CardLayout)container.getLayout();
	          cardLayout.show(container, "3");
	    }
	    
	    
	  }


}
