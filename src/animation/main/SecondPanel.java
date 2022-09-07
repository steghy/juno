package animation.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SecondPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;


	public SecondPanel() {
		init();
	}
	
	private void init() {
			
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		this.setBackground(Color.black);
		
		this.setOpaque(true);
		
		this.add(new JButton("Button 1"));
		this.add(new JButton("Button 2"));
		this.add(new JButton("Button 3"));
		this.add(new JButton("Button 4"));
	}

}

