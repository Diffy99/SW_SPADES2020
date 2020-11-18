package client;

import java.awt.BorderLayout;

import javax.swing.*;


public class AdminPage extends JPanel {

	
	public AdminPage(AdminController apc) {
		
		JPanel admin = new JPanel(new BorderLayout());

		JButton returntoMainMenu = new JButton("Main Menu");
		
		admin.add(returntoMainMenu,BorderLayout.CENTER);
		
		
		
		
	}
}
