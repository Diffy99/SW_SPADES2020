package client.clientpages;

import javax.swing.*;

import client.clientcontrollers.GameBoardController;

public class GameBoardPage extends JPanel {
	
	private JSpinner UserBet;
	private int OppBet;
	
	public GameBoardPage(GameBoardController gbc) {
		
		JPanel board = new JPanel();
		
		
		
		
		
		
		
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
}
