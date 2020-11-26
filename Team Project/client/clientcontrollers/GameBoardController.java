package client.clientcontrollers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import client.GameClient;
import client.clientpages.GameBoardPage;
import client.clientpages.LoginPage;

import java.awt.CardLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class GameBoardController implements ActionListener {

	private boolean makefirstmove;
	private JPanel container;
	private GameClient gameClient;
	private JSlider betSlider;
	private JLabel player1played;
	private JLabel player2played;
	private ArrayList<String> currentHand;

	public JSlider getBetSlider() {
		return betSlider;
	}

	

	public GameBoardController(JPanel container, GameClient gameClient) {
		this.container = container;
		this.gameClient = gameClient;
		makefirstmove = false;
		GameBoardPage gameBoardPage = (GameBoardPage) container.getComponent(6);	
		betSlider = gameBoardPage.getBetSlider();
		player1played = gameBoardPage.getPlayer1Played();
		player2played = gameBoardPage.getPlayer2Played();
		ArrayList<String> currentHand = new ArrayList<String>();
	}

	public void actionPerformed(ActionEvent ae) {
		 String command = ae.getActionCommand();
		 if(command.contains("Card")) {
			 command.replace("Card", "");
			 if(makefirstmove) {
				 player1played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/" + currentHand.get(Integer.parseInt(command)) + ".png")));
			 }
			 else {
				 player2played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/" + currentHand.get(Integer.parseInt(command)) + ".png")));
			 }
			 
		 }
	}

	public void display() {
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "6");
		GameBoardPage gameBoardPage = (GameBoardPage) container.getComponent(6);
		if (makefirstmove) {
			gameBoardPage.setSeverinstructions("You are Player 1");
			// whatever the first move us
		} else {
			gameBoardPage.setSeverinstructions("You are Player 2");
		}
	}

	public boolean isMakefirstmove() {
		return makefirstmove;
	}

	public void setMakefirstmove(boolean makefirstmove) {
		this.makefirstmove = makefirstmove;
	}

	public void setHand(ArrayList<ArrayList<String>> temp) {
		GameBoardPage gameBoardPage = (GameBoardPage) container.getComponent(6);
		if (makefirstmove) {
			gameBoardPage.setCards(temp.get(0));
			currentHand = temp.get(0);
		} else {
			gameBoardPage.setCards(temp.get(1));
			currentHand = temp.get(1);
		}
	}
}
