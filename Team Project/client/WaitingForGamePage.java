package client;


import java.awt.*;

import javax.swing.*;

public class WaitingForGamePage extends JPanel {
	
	
	
	
	public WaitingForGamePage(WaitingForGamePageController wfgpc) {
		
		JPanel status = new JPanel(new BorderLayout());
		JLabel waiting = new JLabel("Waiting For Game to Start");
		status.add(waiting,BorderLayout.CENTER);
		
		
	}

}
