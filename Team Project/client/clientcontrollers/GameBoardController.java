package client.clientcontrollers;

import javax.swing.JPanel;

import client.GameClient;

import java.awt.event.*;

public class GameBoardController implements ActionListener{

	  private JPanel container;
	  private GameClient gameClient;
	
	public GameBoardController(JPanel container, GameClient gameClient) {
		this.container = container;
		this.gameClient = gameClient;
		
	}
	 public void actionPerformed(ActionEvent ae) {
		 
	 }
}
