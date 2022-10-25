package juno.view.main.menu.center; 

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class OptionsButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Instance */
	private static OptionsButton instance;
		
	
	/* Builds the OptionsButton instance */
	private OptionsButton() {
		init();
	}

	
	/**
	 * Returns the OptionsButton instance
	 * @return The OptionsButton instance
	 */
	public static OptionsButton getInstance() {
		if(instance == null) {
			instance = new OptionsButton();
		} return instance;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			temp.setImage(temp.getImage()
					.getScaledInstance(temp.getIconWidth() / 3,
									   temp.getIconHeight() / 3, 0));
			super.setIcon(temp);
		}
	}
	
	
	/* Initialize the OptionsButton instance */
	private void init() {

		// TRASPARENT BUTTON SETTINGS 
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}