package client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenuPage extends JPanel {
	
	public MainMenuPage(MainMenuController mmc)
	  {
	   
	   
	        
	    // Create a panel for the labels at the top of the GUI.
		JPanel labelpanel = new JPanel();
		JLabel playlabel = new JLabel("Press to Play");
		JLabel adminlabel = new JLabel("Press to View Admin Page");
		JLabel logout = new JLabel("Press to Logout");

	    
	    
	    
	    // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton playbutton = new JButton("Play");
	    playbutton.addActionListener(mmc);
	    JButton adminbutton = new JButton("Admin Page");
	    adminbutton.addActionListener(mmc);  
	    JButton logoutbutton = new JButton("Logout");
	    logoutbutton.addActionListener(mmc);
	    buttonPanel.add(playbutton);
	    buttonPanel.add(adminbutton);
	    buttonPanel.add(logoutbutton);

	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(3, 2, 0, 10));
	    grid.add(buttonPanel);
	    grid.add(labelpanel);
	    this.add(grid);
	  }

}
