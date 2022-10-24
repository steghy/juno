package juno.view.audio.north;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NextButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The panel */
	private JPanel panel;
	
	/* The NextButton instance */
	private static NextButton instance;

	
	/* Builds the NextButton instance */
	private NextButton() {
		init();
	}

	
	/**
	 * Returns the NextButton instance 
	 * @return The NextButton instance
	 */
	public static NextButton getInstance() {
		if(instance == null) {
			instance = new NextButton();
		} return instance;
	}
	
	
	/**
	 * Sets the panel of this instance
	 * @param panel A JPanel instance
	 */
	public void setPanel(JPanel panel) {
		if(panel.getHeight() == 0 || panel.getWidth() == 0) {
			throw new IllegalArgumentException("invalid dimension");
		} else {
			this.panel = panel;
		}
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
	
	private void init() {
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
	}
}