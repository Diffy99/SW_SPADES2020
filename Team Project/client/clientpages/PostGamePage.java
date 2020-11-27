package client.clientpages;

import javax.swing.*;

import client.clientcontrollers.PostGameController;
import server.serverdata.PostGameData;

import java.awt.*;
import java.awt.event.*;

public class PostGamePage extends JPanel {
	
	
	
	
	public PostGamePage(PostGameController pgc) {
		
		JPanel page = new JPanel();
		JPanel scoreboardpanel = new JPanel();
		scoreboardpanel.setLayout(new GridLayout(1,1,1,1));
		JPanel gameinfo = new JPanel();
		JPanel next = new JPanel();
		JButton playagain = new JButton("Play Again");
		playagain.addActionListener(pgc);
		JButton quit = new JButton("Quit");
		quit.addActionListener(pgc);
		JLabel scoreboard = new JLabel("ScoreBoard");
		JLabel userScore = new JLabel("Your Score");
		JLabel oppScore = new JLabel("Opponents Score");
		//JLabel actUserScore= new JLabel(GameBoardData.getScore());
		//JLabel actOppScore = new JLabel(GameBoardData.getScore());
		JLabel winnerlabel = new JLabel("The Winner is ");
		//JLabel winner = new JLabel(GameBoardData.getWinner());
		
		scoreboardpanel.add(scoreboard);
		page.setLayout(new GridLayout(3,1,5,5));
		gameinfo.setLayout(new GridLayout(3,2,5,5));
		gameinfo.add(userScore);
	//	gameinfo.add(actUserScore);
		gameinfo.add(oppScore);
		//gameinfo.add(actOppScore);
		//gameinfo.add(winnerlabel);
		//gameinfo.add(winner);
		page.add(scoreboardpanel);
		page.add(gameinfo);
		
		next.setLayout(new GridLayout(1,2,5,5));
		next.add(playagain);
		next.add(quit);
		
		page.add(next);
		
		
		
		
		
		
		
		
		
		
		
	}

}
