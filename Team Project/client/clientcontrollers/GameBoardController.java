package client.clientcontrollers;

import javax.swing.JPanel;

import client.GameClient;
import client.clientpages.GameBoardPage;
import client.clientpages.LoginPage;

import java.awt.CardLayout;
import java.awt.event.*;

public class GameBoardController implements ActionListener{

	private  boolean makefirstmove;
	private JPanel container;
	private GameClient gameClient;
	
	public GameBoardController(JPanel container, GameClient gameClient) {
		this.container = container;
		this.gameClient = gameClient;
		makefirstmove = false;
	}
	 public void actionPerformed(ActionEvent ae) {
		 
	 }
	 
	 public void display() {
		 CardLayout cardLayout = (CardLayout)container.getLayout();
         cardLayout.show(container, "6");
         GameBoardPage gameBoardPage = (GameBoardPage)container.getComponent(6);
         if(makefirstmove) {
        	 gameBoardPage.setSeverinstructions("You are Player 1");
        	 //whatever the first move us
         }
         else {
        	 gameBoardPage.setSeverinstructions("You are Player 2");
         }
	}
	public boolean isMakefirstmove() {
		return makefirstmove;
	}
	public void setMakefirstmove(boolean makefirstmove) {
		this.makefirstmove = makefirstmove;
	}
}
