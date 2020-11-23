package client.clientpages;

import javax.swing.*;
import java.awt.*;
import client.clientcontrollers.AdminController;
import java.awt.event.*;


public class AdminPage extends JPanel {

	private JLabel gamesPlayed;
	private JLabel currentGames;
	private JLabel totalUsers;
	private JLabel onlineUsers;
	
	// Setter for the total games text.
    public void setGamesPlayed(String gamesPlayed)
    {
      this.gamesPlayed.setText(gamesPlayed);
    }

    // Setter for the current games text.
    public void setCurrentGames(String currentGames)
    {
      this.currentGames.setText(currentGames);
    }

    // Setter for the total users text.
    public void setTotalUsers(String totalUsers)
    {
      this.totalUsers.setText(totalUsers);
    }

    // Setter for the online users text.
    public void setOnlineUsers(String onlineUsers)
    {
      this.onlineUsers.setText(onlineUsers);
    }

	public AdminPage(AdminController apc) {
		
		// Label Panel
	    JPanel labelPanel = new JPanel(new GridLayout(4, 2, 5, 5));
	    
	    JLabel gamesPlayedlbl = new JLabel("Total Games Played: ", JLabel.CENTER);
	    gamesPlayed = new JLabel("", JLabel.CENTER);
	    
	    JLabel currentGameslbl = new JLabel("Current # Of Games: ", JLabel.CENTER);
	    currentGames = new JLabel("", JLabel.CENTER);
	    currentGames.setForeground(Color.GREEN);
	    
	    JLabel totalUserslbl = new JLabel("Registered Users: ", JLabel.CENTER);
	    totalUsers = new JLabel("", JLabel.CENTER);
	    
	    JLabel onlineUserslbl = new JLabel("# Of Users Online: ", JLabel.CENTER);
	    onlineUsers = new JLabel("", JLabel.CENTER);
	    
	    labelPanel.add(gamesPlayedlbl);
	    labelPanel.add(gamesPlayed);
	    labelPanel.add(currentGameslbl);
	    labelPanel.add(currentGames);
	    labelPanel.add(totalUserslbl);
	    labelPanel.add(totalUsers);
	    labelPanel.add(onlineUserslbl);
	    labelPanel.add(onlineUsers);
		
	    // Button Panel
	    JPanel buttonPanel = new JPanel(new GridLayout(1,2,5,0));
	    JPanel buttonPanel2 = new JPanel(new BorderLayout());
	    
	    JButton refreshButton = new JButton("Refresh");
	    refreshButton.addActionListener(apc);
	    JButton returntoMainMenu = new JButton("Main Menu");
	    returntoMainMenu.addActionListener(apc);    
	    buttonPanel.add(refreshButton);
	    buttonPanel.add(returntoMainMenu);
	    
	    buttonPanel2.add(buttonPanel, BorderLayout.SOUTH);
	    
	    // Page Title
	    JPanel titlePanel = new JPanel(new GridLayout(1, 1, 0, 0));
	    
	    JLabel title = new JLabel("Admin Page", JLabel.CENTER);
	    title.setFont(new Font("Label.font", Font.PLAIN, 20));
	    
	    titlePanel.add(title);
		
		// Arrange the panels to grid.
	    JPanel grid = new JPanel(new GridLayout(3, 1, 0, 15));
	    grid.add(title);
	    grid.add(labelPanel);
	    grid.add(buttonPanel2);
	    this.add(grid);
		
	}
}
