package juno.view.audio;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class MainBackground extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The panel */
	private JPanel panel;
	
	/* The Background instance */
	private static MainBackground instance;

	
	/* Builds the Background instance */
	private MainBackground() {
		this.setSize(new Dimension(350, 200));
		this.setPreferredSize(new Dimension(350, 200));
		this.setMinimumSize(new Dimension(350, 200));
		this.setMaximumSize(new Dimension(250, 200));
	}

	
	/**
	 * Returns the Background instance
	 * @return The Background instance
	 */
	public static MainBackground getInstance() {
		if(instance == null) {
			instance = new MainBackground();
		} return instance;
	}
	
	
	/**
	 * Sets the panel of this obeject
	 * @param panel A JPanel object
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		if(this.panel != null) {
			if(icon instanceof ImageIcon) {
				Image scaledImage = ((ImageIcon)icon).getImage()
						.getScaledInstance(this.panel.getWidth(), 
										   this.panel.getHeight(), 0);
				super.setIcon(new ImageIcon(scaledImage));
			}
		}
	}
}