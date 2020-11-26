package client.clientcontrollers;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import client.GameClient;
import client.clientpages.GameBoardPage;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameBoardController implements ActionListener {

	private boolean makefirstmove;
	private JPanel container;
	private GameClient gameClient;
	private JSlider betSlider;
	private JLabel player1played;
	private JLabel player2played;
	private ArrayList<String> currentHand;
	private boolean isTurn;
 

	public JSlider getBetSlider() {
		return betSlider;
	}

	public GameBoardController(JPanel container, GameClient gameClient) {
		this.container = container;
		this.gameClient = gameClient;
		makefirstmove = false;
		isTurn = false;
	}

	public void actionPerformed(ActionEvent ae) {
		GameBoardPage gameBoardPage =(GameBoardPage) container.getComponent(6);
		try {
			String command = ae.getActionCommand();
			if (isTurn) {
				if (command.contains("Card")) {
					String card = command.substring(4);
					if (makefirstmove) {
						player1played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/" + currentHand.get(Integer.parseInt(card) - 1) + ".png")));
						JButton selectedCard = (JButton) ae.getSource();
						selectedCard.setEnabled(false);
						selectedCard.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
						gameClient.sendToServer("Player1Card" + currentHand.get(Integer.parseInt(card) - 1));

					} else {
						player2played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/" + currentHand.get(Integer.parseInt(card) - 1) + ".png")));
						JButton selectedCard = (JButton) ae.getSource();
						selectedCard.setEnabled(false);
						selectedCard.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
						gameClient.sendToServer("Player2Card" + currentHand.get(Integer.parseInt(card) - 1));
					}

				}
			} else {
				gameBoardPage.setSeverinstructions("Is not your turn yet");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void display() {
		GameBoardPage gameBoardPage =(GameBoardPage) container.getComponent(6);
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "6");
		if (makefirstmove) {
			gameBoardPage.setSeverinstructions("You are Player 1");
			// whatever the first move us
		} else {
			gameBoardPage.setSeverinstructions("You are Player 2");
		}
		betSlider = gameBoardPage.getBetSlider();
		player1played = gameBoardPage.getPlayer1Played();
		player2played = gameBoardPage.getPlayer2Played();
		ArrayList<String> currentHand = new ArrayList<String>();
		
	}

	public boolean isMakefirstmove() {
		return makefirstmove;
	}

	public void setMakefirstmove(boolean makefirstmove) {
		this.makefirstmove = makefirstmove;
	}

	public void setHand(ArrayList<ArrayList<String>> temp) {
		GameBoardPage gameBoardPage =(GameBoardPage) container.getComponent(6);
		if (makefirstmove) {
			gameBoardPage.setCards(temp.get(0));
			currentHand = temp.get(0);
		} else {
			gameBoardPage.setCards(temp.get(1));
			currentHand = temp.get(1);
		}

	}

	public void recieveCommand(String message) {
		GameBoardPage gameBoardPage =(GameBoardPage) container.getComponent(6);
		// TODO Auto-generated method stub
		String[] command = message.split("|");
		String action;
		if(makefirstmove) {
			action = command[0].substring(7);
			if(action.equals("Wait")) {
				isTurn = false;
				gameBoardPage.setSeverinstructions("Player 2 turn to play card");
			} else if (action.equals("Turn")) {
				isTurn = true;
				gameBoardPage.setSeverinstructions("Player 1 turn to play card");
			}
			else if (action.contains("Display move")) {
				action = action.substring(11);
				player2played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/"+action+".png")));
			}
		}
		else {
			action = command[1].substring(7);
			if(action.equals("Wait")) {
				isTurn = false;
				gameBoardPage.setSeverinstructions("Player 1 turn to play card");
			} else if (action.equals("Turn")) {
				isTurn = true;
				gameBoardPage.setSeverinstructions("Player 2 turn to play card");
			}
			else if (action.contains("Display move")) {
				action = action.substring(11);
				player1played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/"+action+".png")));
			}
		}
				
		
	}
}
