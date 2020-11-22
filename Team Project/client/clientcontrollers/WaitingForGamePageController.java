package client.clientcontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import client.GameClient;

public class WaitingForGamePageController implements ActionListener {
	
	private JPanel container;
	private GameClient gameClient;
	
	public WaitingForGamePageController(JPanel container,GameClient gameClient) {
		this.container = container;
	    this.gameClient = gameClient;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
