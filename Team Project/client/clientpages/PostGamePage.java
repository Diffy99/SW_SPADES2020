package client.clientpages;

import javax.swing.*;

import client.clientcontrollers.PostGameController;
import server.serverdata.PostGameData;

import java.awt.*;
import java.awt.event.*;

public class PostGamePage extends JPanel {
	
	
	
	
	public PostGamePage(PostGameController pgc) {
		
		JPanel page = new JPanel();
		page.setLayout(new GridLayout(2,1,0,150));
		
		
		JPanel titlepanel = new JPanel();
		titlepanel.setLayout(new GridLayout(1,2,0,0));
		JLabel spades = new JLabel("Spades");
		spades.setFont(new Font("Vladimir Script", Font.PLAIN, 89));
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(InitialPage.class.getResource("/cards_png_zip/resized/honors_spade-14.png")));
		
		titlepanel.add(spades);
		titlepanel.add(icon);
		page.add(titlepanel);

		
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(1,2,0,10));
		JButton playagain = new JButton("Play Again");
		playagain.addActionListener(pgc);
		JButton quit = new JButton("Quit");
		quit.addActionListener(pgc);
		buttonpanel.add(playagain);
		buttonpanel.add(quit);
		page.add(buttonpanel);
		
		
		
		
		
		
		
		
		
		
	}

}
