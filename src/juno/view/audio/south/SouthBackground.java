package juno.view.audio.south;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SouthBackground extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The panel */
	private JPanel panel;
	
	/* The Background instance */
	private static SouthBackground instance;

	
	/* Builds the Background instance */
	private SouthBackground() {}

	
	/**
	 * Returns the Background instance
	 * @return The Background instance
	 */
	public static SouthBackground getInstance() {
		if(instance == null) {
			instance = new SouthBackground();
		} return instance;
	}
	
	
	/**
	 * Sets the panel of this object
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
						.getScaledInstance(panel.getWidth(), 
										   panel.getHeight(), 0);
				super.setIcon(new ImageIcon(scaledImage));
			}
		}
	}
}