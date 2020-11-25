package client.clientcontrollers;

import javax.swing.JPanel;

import client.GameClient;

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
         container.setSize(925, 500);
         if(makefirstmove) {
        	 //whatever the first move us
         }
	}
	public boolean isMakefirstmove() {
		return makefirstmove;
	}
	public void setMakefirstmove(boolean makefirstmove) {
		this.makefirstmove = makefirstmove;
	}
}
