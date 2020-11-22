package client.clientpages;

import javax.swing.*;

import client.clientcontrollers.PostGameController;
import server.serverdata.PostGameData;

import java.awt.*;
import java.awt.event.*;

public class PostGamePage extends JPanel {
	
	
	
	
	public PostGamePage(PostGameController pgc) {
		
		JPanel page = new JPanel();
		JPanel gameinfo = new JPanel();
		JPanel next = new JPanel();
		JButton playagain = new JButton("Play Again");
		playagain.addActionListener(pgc);
		JButton quit = new JButton("Quit");
		quit.addActionListener(pgc);
		JLabel userScore = new JLabel("Your Score");
		JLabel oppScore = new JLabel("Opponents Score");
		//JLabel actUserScore= new JLabel(PostGameData.getScore());
		//JLabel actOppScore = new JLabel(PostGameData.getOpponentScore());
		//JLabel winnerlabel = new JLabel("The Winner is ");
		//JLabel winner = new JLabel(PostGameData.getWinner());
		
		
		page.setLayout(new GridLayout(2,1,5,5));
		gameinfo.setLayout(new GridLayout(3,2,5,5));
		gameinfo.add(userScore);
	//	gameinfo.add(actUserScore);
		gameinfo.add(oppScore);
		//gameinfo.add(actOppScore);
		//gameinfo.add(winnerlabel);
		//gameinfo.add(winner);
		page.add(gameinfo);
		
		next.setLayout(new GridLayout(1,2,5,5));
		next.add(playagain);
		next.add(quit);
		
		page.add(next);
		
		
		
		
		
		
		
		
		
		
		
	}

}
