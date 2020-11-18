package client;

import javax.swing.*;
import java.awt.event.*;

public class PostGamePage extends JPanel {
	
	
	
	
	public PostGamePage(PostGameController pgc) {
		
		JPanel page = new JPanel();
		JButton playagain = new JButton("Play Again");
		playagain.addActionListener(pgc);
		JButton quit = new JButton("Quit");
		quit.addActionListener(pgc);
		JLabel userScore = new JLabel("Your Score");
		JLabel oppScore = new JLabel("Opponents Score");
		JLabel actUserScore= new JLabel("");
		JLabel actOppScore = new JLabel("");
		
		
		
		
		
		
	}

}
