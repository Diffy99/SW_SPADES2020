package client.clientpages;

import java.awt.*;

import javax.swing.*;

import client.clientcontrollers.InitialPageController;

import java.awt.event.*;

public class InitialPage extends JPanel {

	
	public InitialPage(InitialPageController ipc) {
		
		JPanel page = new JPanel();
		page.setLayout(new BorderLayout());
		
		JButton start = new JButton("Start");
		start.addActionListener(ipc);
		
		page.add(start,BorderLayout.CENTER);
		
		
		
		
	}
	
}
