package juno.view.abstraction;

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
public abstract class AbstractButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Reference panel */
	private JPanel panel;
	
	/**
	 * Sets the specified JPanel object to 
	 * this object
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

	/** Initialize this object */
	public void init() {
		
		// TRASPARENT BUTTON SETTING
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
	}
}
