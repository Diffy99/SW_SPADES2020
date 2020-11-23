package client.clientpages;

import java.awt.*;

import javax.swing.*;

import client.clientcontrollers.InitialPageController;

import java.awt.event.*;

public class InitialPage extends JPanel {

	
	public InitialPage(InitialPageController ipc) {
		
		JPanel page = new JPanel();
		page.setLayout(new GridLayout(1,1,1,1));
		
		JButton start = new JButton("Start");
		start.addActionListener(ipc);
		
		page.add(start);
		this.add(page);
		
		
		
		
	}
	
}
