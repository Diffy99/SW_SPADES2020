package client.clientpages;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import client.clientcontrollers.AdminController;
import java.awt.event.*;


public class AdminPage extends JPanel {

	
	public AdminPage(AdminController apc) {
		
		JPanel admin = new JPanel(new BorderLayout());

		JButton returntoMainMenu = new JButton("Main Menu");
		
		returntoMainMenu.addActionListener(apc);
		
		admin.add(returntoMainMenu,BorderLayout.CENTER);
		
		
		
		
	}
}
