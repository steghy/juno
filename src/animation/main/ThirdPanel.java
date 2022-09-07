package animation.main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ThirdPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;
	
	public ThirdPanel() {
		init();
	}
	
	private void init() {
		
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		this.setBackground(Color.black);
		
		this.setOpaque(true);
		
		this.add(new JButton("Button 1"));
	}

}
