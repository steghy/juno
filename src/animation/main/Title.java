package animation.main;


import java.awt.Color;
import main.util.PathGenerator;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Title extends JPanel implements ActionListener{

	public static final int PANEL_WIDTH = 500;
	public static final int PANEL_HEIGHT = 500;
	private String imagePath = PathGenerator.generate("/themes/logos/uno-logo-2.png");
	private Image image;
	private Timer timer;
	private int x = 500;
	private int y = 120;
	boolean xval = false;
	boolean yval = false;
	
	private static final long serialVersionUID = 1L;
	
	public Title() {
		init();
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		//x
		if(xval) {
			x -= xVelocity;
			if(x == 500) {
				xval = false;
			}
		}
		else {	
			x = x + xVelocity;
			if(x == 600) {
				xval = true;
			}
		}
		
		//y
		if(yval) {
			y -= yVelocity;
			if(y == 120) {
				yval = false;
			}
		}
		else {
			y += yVelocity;
			if(y == 200) {
				yval = true;
			}
		}
		
		this.repaint();
		*/
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		if(new File(imagePath).exists()) {
			image = new ImageIcon(imagePath).getImage();
		}
		else {
			throw new IllegalArgumentException("invalid path: " + imagePath);
		}
		timer = new Timer(16, this);
		timer.start();
	}

}
