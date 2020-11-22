package client.clientpages;

import javax.swing.*;

import client.clientcontrollers.PostGameController;

import java.awt.event.*;

public class PostGamePage extends JPanel {
	
	
	
	
	public PostGamePage(PostGameController pgc) {
		
		JPanel page = new JPanel();
		page.setLayout(new GridLayout(2,1,5,5));
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(1,3,5,5));
		JPanel next = new JPanel();
		next.setLayout(new GridLayout(1,2,5,5));
		JButton playagain = new JButton("Play Again");
		playagain.addActionListener(pgc);
		JButton quit = new JButton("Quit");
		quit.addActionListener(pgc);
		JLabel userScore = new JLabel("Your Score");
		JLabel oppScore = new JLabel("Opponents Score");
		JLabel actUserScore= new JLabel(PostGameData.getUserScore());
		JLabel actOppScore = new JLabel(PostGameData.getOpponentScore());
		JLabel winnerlabel = new JLabel("The Winner is");
		JLabel winner = new JLabel(PostGameData.getWinner());
		
		results.add(userScore);
		results.add(actUserScore);
		results.add(oppScore);
		results.add(actOppScore);
		results.add(winnerlabel);
		results.add(winner);
		
		next.add(playagain);
		next.add(quit);
		
		page.add(results);
		page.add(next);
		
		
		
		
		
		
		
	}

}
