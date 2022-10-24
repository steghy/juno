package juno.view.main.menu.north;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Logo extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The Logo instance */
	private static Logo instance;

	
	/* Builds the Logo instance */
	private Logo() {
		init();
	}

	
	/**
	 * Returns the Logo instance
	 * @return The Logo instance
	 */
	public static Logo getInstance() {
		if(instance == null) {
			instance = new Logo();
		} return instance;
	}

	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			Image image = temp.getImage();
			image = image.getScaledInstance(temp.getIconWidth() / 2, 
											temp.getIconHeight() / 2, 0);
			super.setIcon(new ImageIcon(image));
		} 
	}
	
	
	/* Initialize the Logo instance */
	private void init() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setOpaque(false);
	}
}