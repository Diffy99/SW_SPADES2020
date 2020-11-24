package client.clientcontrollers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import client.GameClient;

public class WaitingForGamePageController implements ActionListener {
	
	private JPanel container;
	private GameClient gameClient;
	private boolean gamefound;
	
	public WaitingForGamePageController(JPanel container,GameClient gameClient) {
		this.container = container;
	    this.gameClient = gameClient;
	    gamefound = false;
		
		
	}

	public boolean isGamefound() {
		return gamefound;
	}

	public void setGamefound(boolean gamefound) {
		this.gamefound = gamefound;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		 String command = ae.getActionCommand();
		 
		 if(command == "Cancel") {
			 try {
				gameClient.sendToServer("Stop looking for game");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 CardLayout cardLayout = (CardLayout)container.getLayout();
	         cardLayout.show(container, "3");
		 }
		 
		 
		
	}
	
	
	public void waitingforgame() {
		
		while(!gamefound) {
			try {
				Thread.sleep(500);
				gameClient.sendToServer("In Queue");
				Thread.sleep(250);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gamefound = false;
			
		}
		
	}
	
	

}
