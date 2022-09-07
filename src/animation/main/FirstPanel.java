package animation.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;
	public static final LayoutManager DEFAULT_LAYOUT = new FlowLayout(FlowLayout.LEFT, 10, 10);
	
	
	
	
	public FirstPanel() {
		init();
	}
	
	private void init() {
		
		this.setLayout(DEFAULT_LAYOUT);
		
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		this.setBackground(Color.black);
		
		this.setOpaque(true);
		
		this.add(new JButton("Button 1"));
		this.add(new JButton("Button 2"));
		this.add(new JButton("Button 3"));
		this.add(new JButton("Button 4"));
	}

}
