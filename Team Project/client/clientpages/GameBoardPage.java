package client.clientpages;

import javax.swing.*;

import com.sun.prism.Image;
import com.sun.xml.internal.ws.api.server.Container;

import client.clientcontrollers.GameBoardController;
import game_Manager.GameManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class GameBoardPage extends JPanel {
	
	private JSpinner UserBet;
	private int OppBet;
	private JButton Card1;
	private JButton Card2;
	private JButton Card3;
	private JButton Card4;
	private JButton Card5;
	private JButton Card6;
	private JButton Card7;
	private JButton Card8;
	private JButton Card9;
	private JButton Card10;
	private JButton Card11;
	private JButton Card12;
	private JButton Card13;
	private JLabel player1Played;
	private JLabel player2Played;
	private JLabel Severinstructions;
	
	
	public JLabel getSeverinstructions() {
		return Severinstructions;
	}

	public void setSeverinstructions(String severinstructions) {
		Severinstructions.setText(severinstructions);
	}

	public GameBoardPage(GameBoardController gbc) {
		
		
		JPanel board = new JPanel();
		board.setLayout(new BorderLayout());
		JPanel Scoreboard = new JPanel();
		Scoreboard.setLayout(new GridLayout(1,2));
		JLabel Playersscore = new JLabel("Player 1: 0 | Player 2: 0 ");
		Playersscore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Severinstructions = new JLabel("Game Starting");
		Severinstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Scoreboard.add(Playersscore);
		Scoreboard.add(Severinstructions);
		JPanel betPanel = new JPanel();
		Scoreboard.setLayout(new GridLayout(1,2));
		betPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		
		JLabel placebetLabel = new JLabel("Place Bet");
		placebetLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		betPanel.add(placebetLabel);
		JSlider betSlider = new JSlider();
		betSlider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		betSlider.setPaintLabels(true);
		betSlider.setBackground(Color.LIGHT_GRAY);
		betSlider.setPaintTicks(true);
		betSlider.setToolTipText("Set Bet");
		betSlider.setForeground(Color.DARK_GRAY);
		betSlider.setMaximum(13);
		betSlider.setValue(0);
		betSlider.setSnapToTicks(true);
		
		betPanel.add(betSlider);
		JButton confirmBetButton = new JButton("Confirm Bet");
		confirmBetButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		betPanel.add(confirmBetButton);
		
		JPanel handArea = new JPanel();
		handArea.setLayout(new GridLayout(1,13));
		JPanel displayArea = new JPanel();
		displayArea.setLayout(new GridLayout(1,2));
		JPanel playArea = new JPanel();
		playArea.setLayout(new GridLayout(2,1));
		 
	
		
		Card1 = new JButton();
		displayArea.add(Card1);
		
		Card2 = new JButton();
		displayArea.add(Card2);
		
		Card3 = new JButton();
		displayArea.add(Card3);
		
		Card4 = new JButton();
		displayArea.add(Card4);
		
		Card5 = new JButton();
		displayArea.add(Card5);
		
		Card6 = new JButton();
		displayArea.add(Card6);
		
		Card7 = new JButton();
		displayArea.add(Card7);
		
		Card8 = new JButton();
		displayArea.add(Card8);
		
		Card9 = new JButton();
		displayArea.add(Card9);
		
		Card10 = new JButton();
		displayArea.add(Card10);
		
		Card11 = new JButton();
		displayArea.add(Card11);
		
		Card12 = new JButton();
		displayArea.add(Card12);
		
		Card13 = new JButton();
		displayArea.add(Card13);
		
		player1Played = new JLabel();
		player1Played.setHorizontalAlignment(JLabel.CENTER);
		player2Played = new JLabel();
		player2Played.setHorizontalAlignment(JLabel.CENTER);
		player1Played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		player2Played.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		
		Card1.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card2.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card3.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card4.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card5.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card6.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card7.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card8.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card9.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card10.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card11.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card12.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		Card13.setIcon(new ImageIcon(GameBoardPage.class.getResource("/cards_png_zip/resized/gray_back.png")));
		
		
		
		
		
		
		
		
		
		
		
		
		
		board.add(playArea);
		board.add(Scoreboard,BorderLayout.NORTH);
		board.add(betPanel,BorderLayout.SOUTH);
		playArea.add(handArea);
		
		handArea.add(player1Played);
		handArea.add(player2Played);
		playArea.add(displayArea);
		this.add(board);
		
	}
	
	public void showUserMove() {
		
	}
	
	public void showOppMove() {
		
	}
	//public int getUserBet() {
	//	return UserBet;
	//}
//	public void setUserBet(int UserBet) {
	//	this.UserBet = UserBet;
	//}
	public int getOppBet() {
		return OppBet;
	}
	public void setOppBet(int OppBet) {
		this.OppBet = OppBet;
		
	}
	
	public void setCards(ArrayList<String> cards) {
	}
}
